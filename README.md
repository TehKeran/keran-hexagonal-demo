# Keran Fidelity System (KFS)
## Overview
This repository stores an event-centric loyalty system created in Java-Spring with PostgreSQL and Kafka. 

**This loyalty system allows:**
* Create Customer data: loyalty customers, accounts, cards and person data (with address, consent, contact information)
* Create Loyalty data: loyalty programs, events, event configuration (how much points for each event occurrence) and event occurrence (triggered by Kafka)
* React to Kafka events to trigger loyalty event occurrences and recalculate loyalty points in real time
* Register customers and see their data in an Angular front-end (separate repository, link to be provided soon)

## Why?
I created this system in order to showcase my skills as a developer and a designer. This is basically my portfolio work that was influenced by real-life experience in Retail and Insurance businesses. 
Thefeore, this system is **not deployed in any production environment**, the code I wrote is public and can be used by whomever wishes. **I do not put a license on it, so feel free to copy it and use it as you wish, personally or commercially. I hope it helps someone :)**

# Author
My name is Jaroslaw Jarosz. I was born in Poland and lived there for most of my life, but since July 2022 I'm living and working in Barcelona. 
  
I am an IT Business Analyst and a Software Developer. I have over 10 years of experience in Retail and around 2 yeras in Insurance. Currently I am working as both analyst and software developer in Java. I have also experience in .NET (Unity 2D games), Android (kotlin) and Angular.
Visit my sites for more information:
* [My website](https://jaroslaw-jarosz.webflow.io/)
* [LinkedIn](https://www.linkedin.com/in/jaros%C5%82aw-jarosz-93834b113/)
* [Instagram](https://www.instagram.com/tehkeran/)
* [Facebook](https://www.facebook.com/TehKeran/)
* [Google Play profile](https://play.google.com/store/apps/developer?id=Keran&hl=en_AU)


## Management
In case you are interested in knowing how long it took me to produce such a solution, here is a breakdown of my time tracking:
<img width="590" alt="image" src="https://github.com/TehKeran/keran-hexagonal-demo/assets/27728269/076938d0-b6ec-4fd1-b9ce-04ed5966f4b2">

Total number of hours spent:
* 55h (6.875 MD, where 1 MD = 8h)

# Technical design
## Used libraries / technologies
* Java 17
* Multi-module Maven project
* Hexagonal architecture (Domain, Infrastructure, Application)
* Springboot 2.7.8
* PostgreSQL 13
* Swagger, Hibernate, Mapstruct, Lombock, slf4j, Kafka, Jacoco, Mockito

## Modules overview
### Application
Contains the following:
* REST API controllers (defined in .yaml files, generated into controller classes)
* API validation (for checking if provided fields are valid and existing)
* REST-specific data model (apiObjects)

### Domain
Contains the following:
* DTO data model
* Business validation
* Ports (service and persistence interfaces)
* Service implementation

### Infrastructure
Contains the following:
* Postgres data model
* Persistence implementation (DB handling)
* Kafka consumers and handling of loyalty event occurrences

### Modules relations
(TODO: Image)
  
Application --> Domain
  
Infrastructure --> Domain

* All mapping between data models is done by Mapstruct
* All modules are separated, therefore application covers only REST APIs, Domain covers business logic, Infrastructure covers only database and Kafka

## Entity overview
<img width="725" alt="image" src="https://github.com/TehKeran/keran-hexagonal-demo/assets/27728269/8b6bce44-95dd-4c0b-aa3f-6da310e7d8ba">

## Database design
![DB Design](https://github.com/TehKeran/keran-hexagonal-demo/assets/27728269/460faa1e-212a-4e77-a459-1edaf3ad8b94)

# Installation guide
## Quick guide
1. Clone the repository (preferably in IntelliJ)
2. Download Docker Desktop https://www.docker.com/products/docker-desktop/
3. Retrieve the .env and docker-compose file from local-development folder in this repository
4. Open command line, go to the folder with .env and docker-compose and type `docker compose up -d` --> this will start the Kafka server and PostgreSQL server locally
5. Login to PGAdmin `http://localhost:5050/browser/` with credentials defined in the .env file (`admin@admin.com / admin`)
6. Retrieve the SQL script `db_tables.sql` in the Infrastructure/resources folder of this repository and run it in PGAdmin for Keran_db (this will create the DB schema in your local PostgreSQL)
7. Do the same for the other SQL script `db_data.sql` (this will create dictionary data such as loyalty card types and so on)
8. Build the whole solution and run it, it is already pre-configured to connect to the local DB and Kafka set-up in the docker compose file
9. Use Postman or other tool to check out the REST-apis (Postman request file: [postman collections.zip](https://github.com/TehKeran/keran-hexagonal-demo/files/12504838/postman.collections.zip))
