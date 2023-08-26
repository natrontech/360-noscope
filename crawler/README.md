# Data Crawlers

This is a collection of crawlers which grab the desired data and push it to the ELK stack. Each crawler is a Python script which can be run individually.

## Environment variables

Each collector reads the following environment variables:

| Variable           | Description                            |
| ------------------ | -------------------------------------- |
| 'ELASTIC_URI'      | The URI to the ElasticSearch instance. |
| 'ELASTIC_USER'     | The elastic username.                  |
| 'ELASTIC_PASSWORD' | The elastic password.                  |
| 'ELASTIC_INDEX'    | The index to push the data to.         |

## Description

The following JSON reference should be used when pushing data to the ELK stack:

```json
{
  "timestamp": "2023-08-26T02:39:34.096867", //datetime.now().isoformat(),
  "source": "https://example.com",
  "plz": 1234,
  "municipality": "Burgdorf",
  "canton": "BE",
  "dimension": "Umwelt", // one of: "Umwelt" | "Soziales" | "Wirtschaft"
  "theme": "Klima",
  "indicator": "Treibhausgas-Emissione pro Einwohner*in",
  "value": 20
}
```

## Data sources

Each crawler has it's data source declared on the first line of the file. Additionaly the expected return result is also declared at the top of the file.
