# Datasource: https://opendata.geoimpact.ch/energiereporter/energyreporter_municipality_latest.json
# This datasource feeds 4 different indicators.
# The following datasets are extracted from the datasource:
'''
environment -> Energie -> Energieverbrauch pro Person

{
    "@timestamp": '2023-08-26 09:46:56.898755',
    "source": "https://opendata.geoimpact.ch/energiereporter/energyreporter_municipality_latest.json",
    "municipality": "Burgdorf",
    "dimension": "environment",
    "theme": "Energie",
    "indicator": "Energieverbrauch pro Person",
    "value": [<geometry array>]
}
'''


import json
import os
from time import sleep
import requests
from datetime import datetime
from elasticsearch import Elasticsearch
from dataclasses import dataclass
from typing import List, Dict

ElasticURI = os.environ['ELASTIC_PROTOCOL'] + '://' + os.environ['ELASTIC_HOST'] + ':' + os.environ['ELASTIC_PORT']
cache = []

ElasticsearchClient = Elasticsearch(
    ElasticURI,
    basic_auth=(os.environ['ELASTIC_USER'], os.environ['ELASTIC_PASSWORD']),
    verify_certs=False,
    ssl_show_warn=False
)

@dataclass
class Geometry:
    rings: List[List[List[float]]]

@dataclass
class Result:
    featureId: int
    bbox: List[float]
    layerBodId: str
    layerName: str
    id: int
    geometry: Geometry
    attributes: Dict[str, any]

@dataclass
class Data:
    results: List[Result]

def sendDataToElk(Data, gemname):
    DataObject = {
#        "@timestamp": datetime.utcnow(),
        "source": "https://api3.geo.admin.ch/rest/services/api/MapServer/find?layer=ch.swisstopo.swissboundaries3d-gemeinde-flaeche.fill",
        "municipality": gemname,
        "dimension": "geometry",
        "theme": "Metadata",
        "indicator": "municipality",
        "value": Data
    } 
    # Writing to sample.json
    cache.append(DataObject)
    print(DataObject['municipality'])


#    ElasticsearchClient.index(index=os.environ['ELASTIC_INDEX'], body=DataObject)

layerName = 'ch.swisstopo.swissboundaries3d-gemeinde-flaeche.fill'
search = ''
fieldName = 'gemname'
Response = ''
Result = ''
counter = 0
with open('municipality.json') as f:
    municipalityJson=json.load(f)
    for municipality in municipalityJson:
        search = municipality['municipality']
        DataUri = f'https://api3.geo.admin.ch/rest/services/api/MapServer/find?layer={layerName}&searchText={search}&searchField={fieldName}&returnGeometry=true'
        Response = requests.get(DataUri)
        Result = Data(**json.loads(Response.content))
        geometry = Result.results[0]['geometry']
        gemname = Result.results[0]['attributes']['gemname']
        sendDataToElk(geometry,gemname)
        counter += 1
    with open("local_cache.json", "w") as outfile:
        outfile.write(json.dumps(cache, indent=4))
print(counter)
    