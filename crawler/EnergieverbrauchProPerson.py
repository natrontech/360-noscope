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
from elasticsearch import Elasticsearch
from elasticsearch import helpers


ElasticsearchClient = Elasticsearch(
    host=os.environ['ELASTIC_URI'],
    api_key=("id", os.environ['ELASTIC_API_KEY'])
)


DataUri = 'https://opendata.geoimpact.ch/energiereporter/energyreporter_municipality_latest.json'
Data = requests.get(DataUri)
Data = Data.json()


emobilityshare = []
renewableheatingshare = []
elecconsumption = []
pvusage = [] # Solar Usage

for DataPoint in Data:
    if DataPoint["kpiName"] == "emobilityshare":
        emobilityshare.append(DataPoint)
    elif DataPoint["kpiName"] == "renewableheatingshare":
        renewableheatingshare.append(DataPoint)
    elif DataPoint["kpiName"] == "elecconsumption":
        elecconsumption.append(DataPoint)
    elif DataPoint["kpiName"] == "pvusage":
        pvusage.append(DataPoint)

print(pvusage[10])


res = helpers.bulk(ElasticsearchClient, <INSERT_DATA_HERE>)
print(res)