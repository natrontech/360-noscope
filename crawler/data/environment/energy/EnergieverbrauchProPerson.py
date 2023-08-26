# Datasource: https://opendata.geoimpact.ch/energiereporter/energyreporter_municipality_latest.json
# This datasource feeds 4 different indicators.
# The following datasets are extracted from the datasource:
'''
environment -> Energie -> Energieverbrauch pro Person

{
    "@timestamp": '2023-08-26 09:46:56.898755',
    "source": "https://opendata.geoimpact.ch/energiereporter/energyreporter_municipality_latest.json",
    "plz": null,
    "municipality": "Burgdorf",
    "canton": None,
    "dimension": "environment",
    "theme": "Energie",
    "indicator": "Energieverbrauch pro Person",
    "value": 20
}
-----------------------

Umelt -> Energie -> Anteil Elektroautos

{
    "@timestamp": '2023-08-26 09:46:56.898755',
    "source": "https://opendata.geoimpact.ch/energiereporter/energyreporter_municipality_latest.json",
    "plz": null,
    "municipality": "Burgdorf",
    "canton": None,
    "dimension": "environment",
    "theme": "Energie",
    "indicator": "Anteil Elektroautos",
    "value": 20
}
-----------------------

Umelt -> Energie -> Erneuerbar Heizen

{
    "@timestamp": '2023-08-26 09:46:56.898755',
    "source": "https://opendata.geoimpact.ch/energiereporter/energyreporter_municipality_latest.json",
    "plz": null,
    "municipality": "Burgdorf",
    "canton": None,
    "dimension": "environment",
    "theme": "Energie",
    "indicator": "Erneuerbar Heizen",
    "value": 20
}
-----------------------

Umelt -> Energie -> Fortschritt Ausbau Sonnenenergie

{
    "@timestamp": '2023-08-26 09:46:56.898755',
    "source": "https://opendata.geoimpact.ch/energiereporter/energyreporter_municipality_latest.json",
    "plz": null,
    "municipality": "Burgdorf",
    "canton": None,
    "dimension": "environment",
    "theme": "Energie",
    "indicator": "Fortschritt Ausbau Sonnenenergie",
    "value": 20
}
'''


import os
import requests
from datetime import datetime
from elasticsearch import Elasticsearch

ElasticURI = os.environ['ELASTIC_PROTOCOL'] + '://' + os.environ['ELASTIC_HOST'] + ':' + os.environ['ELASTIC_PORT']

ElasticsearchClient = Elasticsearch(
    ElasticURI,
    basic_auth=(os.environ['ELASTIC_USER'], os.environ['ELASTIC_PASSWORD']),
    verify_certs=False,
    ssl_show_warn=False
)


DataUri = 'https://opendata.geoimpact.ch/energiereporter/energyreporter_municipality_latest.json'
Data = requests.get(DataUri)
Data = Data.json()

KpiDictionary = {
    "emobilityshare": "Anteil Elektroautos",
    "renewableheatingshare": "Erneuerbar Heizen",
    "elecconsumption": "Energieverbrauch pro Person",
    "pvusage": "Fortschritt Ausbau Sonnenenergie"
}

def sendDataToElk(Data):
    for DataPoint in Data:
        DataObject = {
            "@timestamp": datetime.utcnow(),
            "source": "https://opendata.geoimpact.ch/energiereporter/energyreporter_municipality_latest.json",
            "municipality": DataPoint["regionName"],
            "dimension": "environment",
            "theme": "Energie",
            "indicator": KpiDictionary[DataPoint["kpiName"]],
            "value": DataPoint["value"] if isinstance(DataPoint["value"], float) else DataPoint["value"]["value"]
        }

        ElasticsearchClient.index(index=os.environ['ELASTIC_INDEX'], body=DataObject)

sendDataToElk(Data)
