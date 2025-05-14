# spring-ai-ollama - Tool Calling

Application to demonstrate the Spring AI integration with Ollama and perform Tool Calling operations.

We will be using two kinds of tooling
1. Local spring component as tools i.e. AI Model communicates to our own java code which in turn returns the result.
2. Accessing an external website. In this case we are going use the freely available US weather forecast website (https://api.weather.gov/gridpoints/BOX/%s/forecast) to get the current weather forecast which is not available in the AI Model. 

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

**cURL - 1 Basic chat with no tooling**
```
curl --location --request GET 'http://localhost:8080/springai/ollama/toolcalling/basic-chat' \
--header 'Content-Type: text/plain' \
--data-raw 'What is current date and time'
```
Response: I'm unable to provide the current date and time

**cURL - 2 Get current date and time with tool calling**
```
curl --location --request GET 'http://localhost:8080/springai/ollama/toolcalling/date-time'
```
Response: Gives you current date and time of you location.

**cURL - 3 Set alarm with tool calling**
```
curl --location --request GET 'http://localhost:8080/springai/ollama/toolcalling/set-alarm?time=10'
```
Response: I have set an alarm for 10 minutes from now.

**cURL - 4 Get tomorrow's day with tool calling**
```
curl --location --request GET 'http://localhost:8080/springai/ollama/toolcalling/tomorrow-day'
```
Response: Give you tomorrow's day

**cURL - 4 Get weather forecast of Boston without tool calling**
```
curl --location --request GET 'http://localhost:8080/springai/ollama/toolcalling/current-weather-without-tool-calling'
```
Response: I'm unable to provide real-time weather updates


**cURL - 5 Get weather forecast of Boston with tool calling**
```
curl --location --request GET 'http://localhost:8080/springai/ollama/toolcalling/current-weather?city=Boston'
```
Response: Give you the weather forecast of Boston
