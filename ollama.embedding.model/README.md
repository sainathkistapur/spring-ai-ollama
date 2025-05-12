# spring-ai-ollama - Embedding Model

_**Note**: To keep the examples lightweight and easy to get quick response we are using the simplest model "**llama3.2:3b**"_

Application to demonstrate the Spring AI Embedding using a Foundation Model.

Embeddings are numerical representations of text, images, or videos that capture relationships between inputs.

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

cURL - Simple embedding with default model
```
curl --location --request GET 'http://localhost:8080/springai/ollama/embedding/simple' \
--header 'Content-Type: text/plain' \
--data-raw 'Tell me a joke'
```

Response: Will be an embedded vector.

cURL - Simple embedding with custom model
```
curl --location --request GET 'http://localhost:8080/springai/ollama/embedding/custom' \
--header 'Content-Type: text/plain' \
--data-raw 'Tell me a joke'
```
Response: Will be an embedded vector but this time generated using custom OpenAI model.

### Ollama Cleanup - Run the following commands
- `docker ps` - to identify Ollama container id
- `docker exec -it <Ollama container id> sh` - to get into the Ollama docker container
- `ollama list` - to get the list of model in the Ollama
- `ollama rm mxbai-embed-large` - to delete the mxbai-embed-large model
- `ollama rm nomic-embed-text` - to delete the nomic-embed-text model
- `exit` - to exit the Ollama conatianer

### Note: Make sure to run `docker-compose down` after you've finished with this module and want to run another module in this repository.