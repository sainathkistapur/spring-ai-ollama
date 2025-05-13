# spring-ai-ollama - Observability

_**Note**: To keep the examples lightweight and easy to get quick response we are using the simplest model "**llama3.2:3b**"_

Application to demonstrate the Spring AI - Observability to get insights into AI-related operations.

We will be exposing the metrics using
- Actuator
- Zipkin (using Springboot docker compose support)

## Running the Application 
### Pre-requisite
- Make sure you have at least 3GB of memory for Docker.

### Run Command
```
mvn spring-boot:run
```
It takes a little time when you first start the application. 
When you **first run** the above command the application with pull the docker image of _Ollama_ and pull the modal into Ollama. 

### Usage
cURL
```
curl --location --request GET 'http://localhost:8080/springai/ollama/basic-chat/observability' \
--header 'Content-Type: text/plain' \
--data-raw 'What is a prompt '
```

##### Check the actuator endpoints
List of available metrics:
`http://localhost:8080/actuator/metrics`

You are particularly interested in these:

```
"gen_ai.client.operation",
"gen_ai.client.operation.active",
"gen_ai.client.token.usage",
"spring.ai.advisor",
"spring.ai.advisor.active",
"spring.ai.chat.client",
"spring.ai.chat.client.active"
```

##### Check the tracing on Zipkin

`http://localhost:9411/zipkin`
