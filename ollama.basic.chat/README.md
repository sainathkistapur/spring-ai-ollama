# spring-ai-ollama - Basic Chat

Application to demonstrate the Spring AI integration with Ollama and perform a simple chat operation.

_**Note**: To keep the examples lightweight and easy to get quick response we are using the simplest model "**gemma3:1b**"_

## Running the Application 
### Pre-requisite
- Make sure you have at least 3GB of memory for Docker.

### Run Command
```
mvn spring-boot:run
```
It takes a little time when you first start the application. 
When you **first run** the above command the application with pull the docker image for _Ollama_ and then Ollama in turn pull the model and initiates. 

### Usage
cURL - Simple chat
```
curl --location --request GET 'http://localhost:8080/springai/ollama/basic-chat' \
--header 'Content-Type: text/plain' \
--data-raw 'What is the capital of UK?'
```
OR you can use the postman collections provided in the project.

You should get a response with details.



### Note: Make sure to run `docker-compose down` after you've finished with this module and want to run another module in this repository.

