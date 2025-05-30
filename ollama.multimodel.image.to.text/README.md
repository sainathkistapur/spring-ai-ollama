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
