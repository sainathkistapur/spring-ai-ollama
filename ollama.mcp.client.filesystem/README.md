# spring-ai-ollama - Model Context Protocol (MCP) - Client using File System server

Application to demonstrate the Spring AI integration with Ollama and perform act as an MCP client accessing the local File System server.

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
curl --location --request GET 'http://localhost:8080/springai/ollama/mcp/client/filesystem/basic-chat' \
--header 'Content-Type: text/plain' \
--data-raw 'what files are in the mcp-filesystem-folder.'
```


#### Other Prompts to try:

- `How many files are inside the mcp-filesystem-folder`
- `How many records are in the employee.json file inside the mcp-filesystem-folder`
- `List all the records from the employee.json file inside the folder mcp-filesystem-folder`
- `What is the last name of Ben from the employee.json file in the mcp-filesystem-folder`

**Note: The result may not be always consistent as we are using a lightweight model which many not perform very well.**

### References
-  [Spring AI](https://docs.spring.io/spring-ai/reference/1.0/api/chat/openai-chat.html)


