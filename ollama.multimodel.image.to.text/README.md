# spring-ai-ollama - Multimodel - Image-To-Text

_**Note**: To keep the examples lightweight and easy to get quick response we are using the simplest model "**gemma3:4b**"_

Application to demonstrate the Spring AI integration with OpenAI to generate a image description.

## Running the Application 
### Pre-requisite
- Make sure you have at least 3GB of memory for Docker.

### Run Command
```
mvn spring-boot:run
```
It takes a little time when you first start the application. 
When you **first run** the above command the application with pull the docker image for _Ollama_ and then Ollama pulls the model in the background. 


### Usage

cURL - Simple Text to Image Generation - The image is stored in the `resources/images` folder
```
curl --location --request GET 'http://localhost:8080/springai/ollama/multimodel/image-to-text'
```

Response: you will get a description of the image that is sent in the prompt.

### Ollama Cleanup - Run the following commands
- `docker ps` - to identify Ollama container id
- `docker exec -it <Ollama container id> sh` - to get into the Ollama docker container
- `ollama list` - to get the list of model in the Ollama
- `ollama rm gemma3:4b` - to delete the gemma3:4b model
- `exit` - to exit the Ollama conatianer

### Note: Make sure to run `docker-compose down` after you've finished with this module and want to run another module in this repository.