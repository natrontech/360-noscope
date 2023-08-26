# fluxcd infrastructure

This directory is an entrypoint for a [flux kustomization](https://fluxcd.io/flux/components/kustomize/kustomizations/).

**Prerequisites**

- Kubernetes cluster with:
  - installed [fluxcd](https://fluxcd.io/) [**required**]
  - installed [eck-operator](https://github.com/elastic/cloud-on-k8s/tree/main/deploy/eck-operator) [**required**]
  - installed [cert-manager](https://cert-manager.io/)
  - installed [kube-prometheus-stack](https://github.com/prometheus-community/helm-charts/tree/main/charts/kube-prometheus-stack)
- Configure a [flux kustomization](https://fluxcd.io/flux/components/kustomize/kustomizations/) to this repository to the path `infra/fluxcd`

## Componentes

- Analyzer Deployment
- Elasticsearch & Kibana Deployment with Metrics, deployed with the [eck-stack](https://github.com/elastic/cloud-on-k8s/blob/main/deploy/eck-stack) & [prometheus-elasticsearch-exporter](https://github.com/prometheus-community/helm-charts/tree/main/charts/prometheus-elasticsearch-exporter) helmchart.
- UI Deployment

## Local templating

Template all resources with [kustomize](https://kubectl.docs.kubernetes.io/):

```bash
cd <repo>/infra/fluxcd

kustomize build .
```