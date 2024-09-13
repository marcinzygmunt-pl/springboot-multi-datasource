Here's a customized `README.md` for the repository you linked:

---

# Spring Boot Multi-Datasource Example

This project demonstrates how to configure and manage multiple data sources in a Spring Boot application.

## Overview

In modern applications, it's common to work with multiple data sources to handle different sets of data or for microservice-based architectures. This project showcases how to integrate and configure multiple data sources using Spring Boot, Spring Data JPA, and HikariCP for connection pooling.

The application is designed with two separate databases, each mapped to a different entity manager, enabling seamless interactions with both databases within the same Spring Boot project.

## Features

- Setup of multiple data sources with Spring Boot.
- Separate configuration and transaction management for each data source.

## Technologies Used

- **Spring Boot**
- **Spring Data JPA**
- **PostgresSQL** (or other relational databases)
- **Maven** (Dependency Management)

## Prerequisites

Before running this project, ensure you have the following installed:
- Java 11 or higher
- Maven 3.6 or higher
- Docker

## Getting Started

Follow these steps to get the project up and running:

### 1. Clone the repository

```bash
git clone https://github.com/marcinzygmunt-pl/springboot-multi-datasource.git
cd springboot-multi-datasource
```

### 2. Configure your databases

Modify the `application.yml` file located in `src/main/resources` to provide your own database configurations:

### 3. Database server

You will need also to set up two separate databases on your local machine, remote server or just use docker-compose.yml file.
```aiignore
docker compose up -d docker/docker-compose.yml
```
For local or remote database structure and data you can use sample sql scripts
```aiignore
docker/db_primary.sql
docker/db_secondary.sql
```

### 4. Build the project

Use Maven to build the project:

```bash
mvn clean install
```

### 5. Run the application

You can run the project using the following command:

```bash
mvn spring-boot:run
```

The application will start and connect to the configured databases.

### 6. Test the API

You can use a tool like Postman or `cURL` to test the endpoints. Example CRUD endpoints are provided for interacting with both databases.
