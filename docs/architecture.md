# Architecture

![Architecture](./assets/architecture.png)

## Component Diagram

![Component Diagram](./assets/componentDiagram.jpg)

### Data Crawler

The Data Crawler consists of a collection of crawlers which grab the desired data and push it to the ELK stack. Each crawler is a Python script which can be run individually.

### Elasticsearch (Data persistence)

The data is persisted in an [Elasticsearch](https://www.elastic.co/elasticsearch/).

#### Kibana

Before we display the data on the frontend, we also can deploy [Kibana](https://www.elastic.co/kibana/) and browse the data of Elasticsearch, create dashboards etc.

### Analyzer

The analyzer component is written with Java Spring Boot. The analyzer reads the data from Elasticsearch, transforms it according to the indicator definitions and makes it available to the frontend in a unified format as a REST API. Additionally, the Analyzer takes the answers of the surveys and saves them to Elasticsearch.

#### REST-API Documentation

You can find the Swagger API Documentation here: [openapi-docs.json](./assets/openapi-docs.json) or on following URL: http://127.0.0.1:8000/swagger-ui/index.html (see [getting started](./getting-started)).

### UI

Consists of two components:

- **frontend**: The web interface is written in Svelt.
- **backend**: We use [Pocketbase](https://pocketbase.io/) as backend.

The UI reads the data from the REST-API of the analyzer and displays the data. It also can create an display surveys.
