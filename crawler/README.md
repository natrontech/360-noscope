# Data Crawlers

## Environment variables

Each collector reads the following environment variables:

| Variable          | Description                                 |
| ----------------- | ------------------------------------------- |
| 'ELASTIC_URI'     | The URI to the ElasticSearch instance.      |
| 'ELASTIC_API_KEY' | The API key for the ElasticSearch instance. |

## Description

The following JSON reference should be used when pushing data to the ELK stack:

```json
{
    "timestamp": datetime.now().isoformat(),
    "source": "https://example.com",
    "plz": 1234,
    "municipality": "Burgdorf",
    "canton": "BE",
    "dimension": "Umwelt" | "Soziales" | "Wirtschaft", # one of the three
    "theme": "Klima",
    "indicator": "Treibhausgas-Emissione pro Einwohner*in",
    "value": "20%"
}
```

## Data sources

Each crawler has it's data source declared on the first line of the file. The data source is a URL to the data source.
