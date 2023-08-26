# Datasource: https://opendata.geoimpact.ch/energiereporter/energyreporter_municipality_latest.json
# This datasource feeds 4 different indicators. 
# The following datasets are extracted from the datasource:
'''
Umwelt -> Energie -> Energieverbrauch pro Person

{
    "timestamp": "2023-08-26T02:39:34.096867",
    "source": "https://opendata.geoimpact.ch/energiereporter/energyreporter_municipality_latest.json",
    "plz": null,
    "municipality": "Burgdorf",
    "canton": "BE",
    "dimension": "Umwelt",
    "theme": "Energie",
    "indicator": "Energieverbrauch pro Person",
    "value": 20
}
-----------------------

Umelt -> Energie -> Anteil Elektroautos

{
    "timestamp": "2023-08-26T02:39:34.096867",
    "source": "https://opendata.geoimpact.ch/energiereporter/energyreporter_municipality_latest.json",
    "plz": null,
    "municipality": "Burgdorf",
    "canton": "BE",
    "dimension": "Umwelt",
    "theme": "Energie",
    "indicator": "Anteil Elektroautos",
    "value": 20
}
-----------------------

Umelt -> Energie -> Erneuerbar Heizen

{
    "timestamp": "2023-08-26T02:39:34.096867",
    "source": "https://opendata.geoimpact.ch/energiereporter/energyreporter_municipality_latest.json",
    "plz": null,
    "municipality": "Burgdorf",
    "canton": "BE",
    "dimension": "Umwelt",
    "theme": "Energie",
    "indicator": "Erneuerbar Heizen",
    "value": 20
}
-----------------------

Umelt -> Energie -> Produktion Solarstrom

{
    "timestamp": "2023-08-26T02:39:34.096867",
    "source": "https://opendata.geoimpact.ch/energiereporter/energyreporter_municipality_latest.json",
    "plz": null,
    "municipality": "Burgdorf",
    "canton": "BE",
    "dimension": "Umwelt",
    "theme": "Energie",
    "indicator": "Produktion Solarstrom",
    "value": 20
}
'''


import os
import requests
from datetime import datetime
from elasticsearch import Elasticsearch
from elasticsearch import helpers


ElasticsearchClient = Elasticsearch(
    hosts=os.environ['ELASTIC_URI'],
    basic_auth=(os.environ['ELASTIC_USER'], os.environ['ELASTIC_PASSWORD'])
)


DataUri = 'https://opendata.geoimpact.ch/energiereporter/energyreporter_municipality_latest.json'
Data = requests.get(DataUri)
Data = Data.json()

KpiDictionary = {
    "emobilityshare": "Anteil Elektroautos",
    "renewableheatingshare": "Erneuerbar Heizen",
    "elecconsumption": "Energieverbrauch pro Person",
    "pvusage": "Produktion Solarstrom"
}

def createDataObjectsForElk(Data):
    DataObjects = []
    for DataPoint in Data:
        DataObject = {
            "timestamp": datetime.now().isoformat(),
            "source": "https://opendata.geoimpact.ch/energiereporter/energyreporter_municipality_latest.json",
            "plz": None,
            "municipality": DataPoint["regionName"],
            "canton": None,
            "dimension": "Umwelt",
            "theme": "Energie",
            "indicator": KpiDictionary[DataPoint["kpiName"]],
            "value": DataPoint["value"] if isinstance(DataPoint["value"], float) else DataPoint["value"]["value"]
        }
  
        DataObjects.append(DataObject)
    return DataObjects



DataObjects = createDataObjectsForElk(Data)
print(DataObjects[5])
print(DataObjects[3000])
print(DataObjects[-1])
res = helpers.bulk(ElasticsearchClient, DataObjects, index=os.environ['ELASTIC_INDEX'])
print(res)