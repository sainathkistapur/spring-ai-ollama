# spring-ai-ollama - Chat Memory - InMemory

_**Note**: To keep the examples lightweight and easy to get quick response we are using the simplest model "**llama3.2:3b**"_

Application to demonstrate the Spring AI integration with Ollama and perform a conversational chat using InMemory storage.

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

#### Scenario 1:  Simple chat with no memory usage
cURL - Request 1
```
curl --location --request GET 'http://localhost:8080/springai/ollama/chat/memory/in-memory/prompt-with-no-memory' \
--header 'conversationId: CID-1' \
--header 'Content-Type: text/plain' \
--data-raw 'My name is John'
```
Response: Will be a greeting message from the chat model

cURL - Request 2
```
curl --location --request GET 'http://localhost:8080/springai/ollama/chat/memory/in-memory/prompt-with-no-memory' \
--header 'conversationId: CID-1' \
--header 'Content-Type: text/plain' \
--data-raw 'What is my name?'
```
Response: Something like "I don't have access to personal data"


#### Scenario 2:  Chat with InMemory usage
cURL - Request 1 - Note: `conversationId` must be unique for each conversation.
```
curl --location --request GET 'http://localhost:8080/springai/ollama/chat/memory/in-memory/prompt-with-in-memory' \
--header 'conversationId: CID-2' \
--header 'Content-Type: text/plain' \
--data-raw 'My name is John'
```
Response: Will be a greeting message from the chat model

cURL - Request 2 - Note: `conversationId` must be unique for each conversation.
```
curl --location --request GET 'http://localhost:8080/springai/ollama/chat/memory/in-memory/prompt-with-in-memory' \
--header 'conversationId: CID-2' \
--header 'Content-Type: text/plain' \
--data-raw 'What is my name?'
```
Response: Your name is John.
