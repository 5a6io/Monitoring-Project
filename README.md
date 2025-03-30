# Monitoring Project

## The Objective

- Test using Locust
- Scheduling using HPA
- Visualization and analysis with Grafana
- More than 90 rps

### Environment

![Using](https://go-skill-icons.vercel.app/api/icons?i=spring,postgresql,kubernetes,gcp,kafka)

- Google Kubernetes Engine
  - machine: e2-standard-2 ➡️ app, e2-micro ➡️ cicd
  - the number of default nodes: 1 ~ 2 nodes per a zone
  - autoscaling: 0 ~ 2kube nodes per a zone. max: 6
- Google Cloud SQL
  - PostgreSQL 17
- Spring Boot:3.4.2
- Kubernetes:v1.31.5
- Kafka:3.9.0

### Monitoring

![Using Tool](https://go-skill-icons.vercel.app/api/icons?i=grafana,prometheus)

- Prometheus
- Grafana

![Architecture Diagram](Monitoring-Project.drawio.png)

### CI/CD

![CI/CD](https://go-skill-icons.vercel.app/api/icons?i=github,argocd,docker)

- GitHub Action
- ArgoCD
- Docker

![CI/CD](cicd.png)

## The Process
|Order|✅|
|:-----|:----:|
|1. Develop App-server|✅|
|2. Install ArgoCD and Deploy server|✅|
|3. Set Prometheus&Grafana|✅|
|4. Install Locust and Test|✅|
|5. Configure HPA|✅|
|6. Analysis with changing variables|✅|
|7. Configure Kafka|✅|
|8. Retest and Compared with prior results|✅|
