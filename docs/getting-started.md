# Getting Started

This chapter shows the various ways to run and deploy the application. After the application is running (locally), you can access it under the following URLs:

- Frontend (Pocketbase): http://localhost:8090/login
- Backend (Pocketbase): http://localhost:8090/_/
- Analyzer: http://localhost:8000

## Docker Compose (local deployment)

**Prerequisites**

- Access to an Elasticsearch Cluster with Kibana
- Edit `docker-compose.yaml` (update environment variables for elasticsearch)

```bash
git clone git@github.com:natrontech/360-noscope.git
cd 360-noscope

docker-compose up -d
```

> This will build the docker images locally. Instead of building the images yoursel, you can use the [pre-built docker-images](https://github.com/orgs/natrontech/packages?repo_name=360-noscope) from the GitHub registry.

## Kubernetes

You can deploy the application in your Kubernetes cluster, but you have to set all the env variables.

### Environment Variables

You need to set the following environment:

**Analyzer**

| ENV                 | Description                                                                                 |
| ------------------- | ------------------------------------------------------------------------------------------- |
| `ELASTIC_URI`       | URL with protocol & port of the elasticsearch, e.g. `http://elasticsearch.example.com:9200` |
| `ELASTIC_USERNAME`  | Username for elasticsearch access                                                           |
| `ELASTIC_PASSWORD`  | Password for elasticsearch access                                                           |
| `SECURITY_USERNAME` | User for spring api access                                                                  |
| `SECURITY_PASSWORD` | Password for spring api access                                                              |

## Analyzer API Documentation

You can find the Swagger API Documentation of the Analyzer component on following URL: http://127.0.0.1:8000/swagger-ui/index.html