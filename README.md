# Distributed AI Operations Platform

A production-oriented distributed systems and AI operations platform built with Java 25.

The project is designed as a multi-module architecture for distributed workflow execution, scheduling, worker orchestration, resource management, event-driven communication, observability, and AI-assisted incident analysis.

## Technology Stack

- Java 25
- Spring Boot
- Maven
- gRPC
- Protocol Buffers
- Apache Kafka
- PostgreSQL
- Redis
- OpenTelemetry
- Docker
- Kubernetes
- Python / FastAPI for ML services

## Architecture

The platform is organized as a Maven multi-module project.

```text
distributed-ai-operations/
├── contracts/
├── platform-support/
├── workflow-service/
├── scheduler-service/
├── resource-service/
├── worker-service/
├── incident-service/
├── analytics-service/
├── api-gateway/
└── ml-service/