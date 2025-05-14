# spring-ai-ollama - Model Context Protocol (MCP) - Client using PostgreSQL DB as server

Application to demonstrate the Spring AI integration with Ollama and perform act as an MCP client accessing the PostgreSQL DB in the read only mode.

_**Note**: To keep the examples lightweight and easy to get quick response we are using the simplest model "**llama3.2:3b**"_

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

cURL
```
curl --location --request GET 'http://localhost:8080/springai/ollama/mcp/client/postgresql/basic-chat' \
--header 'Content-Type: text/plain' \
--data-raw 'Is there anyone with firstname John in account? If so what is date of birth or dob?'
```

### Other Prompts to try:

- `List all the records in the Json format from the account table.`
- `How many records are in the account table?`

### References
-  [Spring AI](https://docs.spring.io/spring-ai/reference/1.0/api/chat/openai-chat.html)

