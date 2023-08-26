import requests
import config
import models
import json

def getLayers():

    res = requests.get(config.LAYER_ENDPOINT)
    res_json = json.loads(res.content)

    map_server = models.MapServer(**res_json)

    return map_server
