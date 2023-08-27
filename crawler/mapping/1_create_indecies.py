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

indecies = ["quantitative-data","municipalities","themes","dimensions","geo-data"]

for i in indecies:
    if not ElasticsearchClient.indices.exists(index=i):
        ElasticsearchClient.indices.create(index=i, ignore=400)
        print("Index " + i + " created")
