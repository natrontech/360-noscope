import os
import requests
from datetime import datetime
import json
from elasticsearch import Elasticsearch, helpers

ElasticURI = os.environ['ELASTIC_PROTOCOL'] + '://' + os.environ['ELASTIC_HOST'] + ':' + os.environ['ELASTIC_PORT']

ElasticsearchClient = Elasticsearch(
    ElasticURI,
    basic_auth=(os.environ['ELASTIC_USER'], os.environ['ELASTIC_PASSWORD']),
    verify_certs=False,
    ssl_show_warn=False
)

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


# Municipalities
with open('data.json') as json_file:
    data = json.load(json_file)
    upload_data_elastic('municipalities', data)

# Themes
with open('themes.json') as json_file:
    data = json.load(json_file)
    upload_data_elastic('themes', data)

# Dimensions
with open('dimensions.json') as json_file:
    data = json.load(json_file)
    upload_data_elastic('dimensions', data)
