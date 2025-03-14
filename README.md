# Sensor Data Microservice
This microservice consumes sensor data messages from an Apache Kafka topic and broadcasts them to connected WebSocket clients. It is built using Java Spring Boot for optimal performance and scalability.

## Prerequisites

Ensure you have the following installed:

- Docker
- Docker Compose

## Getting Started

### 1. Clone the Repository
1. Open IntelliJ IDEA.
2. Go to File → New → Project from Version Control...
3. Enter your repository URL and clone the project.

### 2. Run the Project with Docker Compose
To start the entire system (microservice, database, and Kafka):

1. Open the Terminal tab in IntelliJ.
2. Run the following command:
```bash
docker-compose up

```
This will:
- Start the microservice.
- Launch MySql and Kafka as dependencies.
- Expose the microservice on port **8082**.

### 3. Database
Sensor data will be fetch from MySql table called `sensor_data`.

### 4. Kafka Integration
The microservice will automatically consume sensor data from the Kafka topic.

### 5. Websocket
This microservice will send to the client sensor data using websocket

### 5. Stopping the Project
To stop the containers, run:

```bash
docker-compose down
```