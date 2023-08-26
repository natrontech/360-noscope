# Datasource: https://opendata.geoimpact.ch/energiereporter/energyreporter_municipality_latest.json
# This datasource feeds 4 different indicators.
# The following datasets are extracted from the datasource:
'''
environment -> energy -> Energieverbrauch pro Person
environment -> energy -> Anteil Elektroautos
environment -> energy -> Erneuerbar Heizen
environment -> energy -> Fortschritt Ausbau Sonnenenergie

{
    "@timestamp": '2023-08-26 09:46:56.898755',
    "source": "https://opendata.geoimpact.ch/energiereporter/energyreporter_municipality_latest.json",
    "municipality": "Burgdorf",
    "dimension": "environment",
    "theme": "energy",
    "indicator": "Fortschritt Ausbau Sonnenenergie",
    "value": 20
}
'''

# Variables
index = "geo-data"
dimension = "geometry"
indicator = "hochmoore"
theme = "Metadata"
source = "https://api3.geo.admin.ch/rest/services/api/MapServer/ch.bafu.bundesinventare-hochmoore"
lowerId = 1519
upperId = 9723
layername = "ch.bafu.bundesinventare-hochmoore"


import os
import requests
from datetime import datetime
from elasticsearch import Elasticsearch, helpers
import json
from time import sleep
import sys
sys.path.append("../../../arcgis")
# import service from service.py
import service

# Elastic Client
ElasticURI = os.environ['ELASTIC_PROTOCOL'] + '://' + os.environ['ELASTIC_HOST'] + ':' + os.environ['ELASTIC_PORT']
ElasticsearchClient = Elasticsearch(
    ElasticURI,
    basic_auth=(os.environ['ELASTIC_USER'], os.environ['ELASTIC_PASSWORD']),
    verify_certs=False,
    ssl_show_warn=False
)

# Web request
Data = service.geometries_for_values(layername, "id", lowerId, upperId)

def upload_data_elastic(index, data):

    # Prepare data for bulk operation
    bulk_data = []
    for i in data:
        bulk_data.append({
            '_index': index,
            '_source': i
        })
        
    # Send data to elasticsearch using bulk operation
    try:
        helpers.bulk(ElasticsearchClient, bulk_data)
        # Print success message
        print(f"{len(bulk_data)} entities created")
    except helpers.BulkIndexError as e:
        # Print error message for each failed document
        for error in e.errors:
            print(f"Failed to index document: {error['index']['_id']}, reason: {error['index']['error']['reason']}")

DataBulk = []
for DataPoint in Data:
    # Upload data to elastic
    DataBulk.append({
    #    "@timestamp": datetime.utcnow(),
        "source": source,
        "dimension": dimension,
        "theme": theme,
        "indicator": indicator,
        "value": DataPoint
    })
with open(f"local_cache_{indicator}.json", "w") as outfile:
    outfile.write(json.dumps(DataBulk, indent=4))
    
upload_data_elastic(index, DataBulk)
