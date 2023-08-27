# Getting Started

This chapter shows the various ways to run and deploy the application. After the application is running (locally), you can access it under the following URLs:

- Frontend: http://localhost:8090/login
- Backend (Pocketbase): http://localhost:8090/_/
- Analyzer: http://localhost:8000

## Docker Compose (local deployment)

**Prerequisites**

- Access to an Elasticsearch Cluster
- Edit `docker-compose.yaml` (update environment variables)
- Start docker containers

```bash
# go to the root of this repository

docker-compose up -d
```

> This will build the docker images locally. Instead of building the images yourself, you can use the [pre-built docker-images](https://github.com/orgs/natrontech/packages?repo_name=360-noscope) from the GitHub registry.

Use the `image` instead of the `build` configuration:

```yaml
version: '3.9'
services:

  analyzer:
    image: ghcr.io/natrontech/360-noscope-analyzer:latest
    #build: ./analyze
(...)

  frontend:
    image: ghcr.io/natrontech/360-noscope-frontend:latest
    #build: ./ui
```

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

## Kubernetes

You can deploy the application in your Kubernetes cluster. See the files in following directory for more informations: [infra/fluxcd](../infra/fluxcd/).
