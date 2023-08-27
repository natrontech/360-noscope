# Variables
index = "geo-data"
dimension = "geometry"
indicator = "flachmoore"
theme = "Metadata"
source = "https://api3.geo.admin.ch/rest/services/api/MapServer/ch.bafu.bundesinventare-flachmoore"
lowerId = 13275
upperId = 14609
layername = "ch.bafu.bundesinventare-flachmoore"


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
