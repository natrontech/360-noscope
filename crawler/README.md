# Data Crawlers

This is a collection of crawlers which grab the desired data and push it to the ELK stack. Each crawler is a Python script which can be run individually.

## Environment variables

Each collector reads the following environment variables:

| Variable           | Description                                |
| ------------------ | ------------------------------------------ |
| 'ELASTIC_HOST'     | The elastic host. i.e. elastic.example.com |
| 'ELASTIC_PORT'     | The elastic port. i.e. 9200                |
| 'ELASTIC_PROTOCOL' | The elastic protocol. i.e. https           |
| 'ELASTIC_USER'     | The elastic username.                      |
| 'ELASTIC_PASSWORD' | The elastic password.                      |
| 'ELASTIC_INDEX'    | The index to push the data to.             |

## Description

The following JSON reference should be used when pushing data to the ELK stack:

```json
{
  "timestamp": "2023-08-26T02:39:34.096867", //datetime.now().isoformat(),
  "source": "https://example.com",
  "plz": 1234,
  "municipality": "Burgdorf",
  "canton": "BE",
  "dimension": "environment", // one of: "environment" | "social" | "economy"
  "theme": "Klima",
  "indicator": "Treibhausgas-Emissione pro Einwohner*in",
  "value": 20
}
```

## Data sources

Each crawler has it's data source declared on the first line of the file. Additionaly the expected return result is also declared at the top of the file.

## Setup Dev Environment

```bash
cd into/this/directory
python3 -m venv .venv
source .env
source .venv/bin/activate
pip install -r requirements.txt
```
