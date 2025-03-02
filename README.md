# Monitoring Project

## The Objective

- Test with Locust
- Scheduling using HPA
- Visualization and analysis with Grafana

### Environment

![Using](https://go-skill-icons.vercel.app/api/icons?i=spring,mysql,postgresql,kubernetes,gcp,terraform)

- Google Kubernetes Engine
- Google Cloud SQL
- Spring Boot:3.4.2
- Kubernetes:1.31.0
- Database
  - Local: MySQL
  - Test: PostgreSQL

### Monitoring

![Using Tool](https://go-skill-icons.vercel.app/api/icons?i=grafana,prometheus)

- Prometheus
- Grafana

![Architecture Diagram](Monitoring-Project.drawio.png)

### CI/CD

![CI/CD](https://go-skill-icons.vercel.app/api/icons?i=github,argocd,docker)

- GitHub Webhook
- Jenkins
- ArgoCD
- Docker
- Ansible

![CI/CD](cicd.png)

## The Process
|Order|✅|
|:-----|:----:|
|1. Develop App-server|✅|
|2. Install ArgoCD and Deploy server|✅|
|3. Set Prometheus&Grafana|✅|
|4. Configure HPA|✅|
|5. Install Locust and Test||
|6. Analysis with changing variables||
|7. Compare Karpenter&GKE Auto Scheduling||