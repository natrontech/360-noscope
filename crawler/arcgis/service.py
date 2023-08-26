import requests
import json
import models

def search_values_by_layer(layerName, fieldName):
    req = f'https://api3.geo.admin.ch/rest/services/api/MapServer/{layerName}'
    response = requests.get(req)
    data = models.DataEntry(**json.loads(response.content))
    for f in data.fields:
        if f['name'] == fieldName:
            return f['values']

def geometry_by_layer_and_value(layerName, fieldName, value):
    data = find(layerName, value, fieldName)
    return data.results[0]['geometry']

def geometries_for_values(layerName, fieldName):
    geometries = []
    vs = search_values_by_layer(layerName, fieldName)
    for v in vs:
        geometries.append(geometry_by_layer_and_value(layerName, fieldName, v))
    return geometries

def find(layerName, search, fieldName):
    requestUrl = f'https://api3.geo.admin.ch/rest/services/api/MapServer/find?layer={layerName}&searchText={search}&searchField={fieldName}&returnGeometry=true'
    response = requests.get(requestUrl)
    if response.status_code == 200:
        return models.Data(**json.loads(response.content))
    raise Exception(f'failed requesting {requestUrl}')
