# spring-ai-ollama - Structured Output Converter - Bean Converter

_**Note**: To keep the examples lightweight and easy to get quick response we are using the simplest model "**llama3.2:3b**"_

Application to demonstrate the Spring AI integration with Ollama and perform a simple prompt operation that converts the response to a bean using `BeanOutputConverter`.

## Running the Application 
### Pre-requisite
- Make sure you have at least 3GB of memory for Docker.

### Run Command
```
mvn spring-boot:run
```
It takes a little time when you first start the application. 
When you **first run** the above command the application with pull the docker image of _Ollama_ and pull the _llama3.2:3b_ modal into Ollama. 

### Usage

**Step 1:** First check how the application responds without the bean converter
cURL
```
curl --location --request GET 'http://localhost:8080/springai/ollama/prompt/simple' \
--header 'Content-Type: text/plain' \
--data-raw 'List top 5 career achievements of Tom Cruise.'
```

**Step 2:** Now check how the application responds with the bean converter
cURL
```
curl --location --request GET 'http://localhost:8080/springai/ollama/prompt/simple/with-bean-converter' \
--header 'Content-Type: text/plain' \
--data-raw 'List top 5 career achievements of Tom Cruise.'
```

### Note: Make sure to run `docker-compose down` after you've finished with this module and want to run another module in this repository.