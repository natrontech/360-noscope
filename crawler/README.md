# Data Crawlers

## Environment variables

Each collector reads the following environment variables:

| Variable      | Description                            |
| ------------- | -------------------------------------- |
| 'ELASTIC_URI' | The URI to the ElasticSearch instance. |

## Description

The following JSON reference should be used when pushing data to the ELK stack:

```json
{
    "timestamp": datetime.now().isoformat(),
    "source": "https://example.com",
    "plz": 1234,
    "municipality": "Burgdorf",
    "canton": "BE",
    "Dimension": "umwelt" | "soziales" | "wirtschaft", # one of the three
    "theme": "klima",
    "indicator": "Treibhausgas-Emissione pro Einwohner*in",
    "value": "20%"
}
```

## Data sources

Each crawler has it's data source declared on the first line of the file. The data source is a URL to the data source.
