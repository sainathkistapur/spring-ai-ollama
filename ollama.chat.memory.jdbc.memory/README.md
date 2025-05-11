# spring-ai-openai - Chat Memory - Jdbc Memory

_**Note**: To keep the examples lightweight and easy to get quick response we are using the simplest model "**llama3.2:3b**"_

Application to demonstrate the Spring AI integration with Ollama and perform a conversational chat using JDBC storage.

**Important**: `"conversationId"` Request Header  in each request is used to identify and isolate individual conversation from other conversations.

We will be using
- PostgreSQL DB for storing the chat memory (As of now only PostgreSQL and MariaDB are supported by the Spring AI.)
- Springboot Docker Compose support to build and run the DB scripts at run time.


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
curl --location --request GET 'http://localhost:8080/springai/ollama/chat/memory/jdbc-memory/prompt-with-no-memory' \
--header 'conversationId: CID-1' \
--header 'Content-Type: text/plain' \
--data-raw 'My name is John'
```
Response: Will be a greeting message from the chat model

cURL - Request 2
```
curl --location --request GET 'http://localhost:8080/springai/ollama/chat/memory/jdbc-memory/prompt-with-no-memory' \
--header 'conversationId: CID-1' \
--header 'Content-Type: text/plain' \
--data-raw 'What is my name?'
```
Response: Something like "I don't have access to personal data"


#### Scenario 2:  Chat with Jdbc Memory usage
cURL - Request 1 - Note: `conversationId` must be unique for each conversation.
```
curl --location --request GET 'http://localhost:8080/springai/ollama/chat/memory/jdbc-memory/prompt-with-jdbc-memory' \
--header 'conversationId: CID-2' \
--header 'Content-Type: text/plain' \
--data-raw 'My name is John'
```
Response: Will be a greeting message from the chat model

Now you can check the DB table `ai_chat_memory` and see entries for both input and output messages.

cURL - Request 2 - Note: `conversationId` must be unique for each conversation.
```
curl --location --request GET 'http://localhost:8080/springai/ollama/chat/memory/jdbc-memory/prompt-with-jdbc-memory' \
--header 'conversationId: CID-2' \
--header 'Content-Type: text/plain' \
--data-raw 'What is my name?'
```
Response: Your name is John.


### Note: Make sure to run `docker-compose down` after you've finished with this module and want to run another module in this repository.