# spring-ai-ollama
Repository to store all Spring AI integration with AI modals using Ollama

### Pre-requisite
- Make sure you have at least 3GB of memory for Docker.

### **Please Note:** 
- All the module in the repository are designed to run individually. So due to docker container naming conflict make sure you run `docker-compose down` after you've finished with each module and before running the new module.
- The response times could be varied depending on the system you are running the model.
- If you receive this error when running the prompt it means that Ollama is still fetching and loading the model. Give few more seconds and retry.
`"org.springframework.ai.retry.NonTransientAiException: 404 - {"error":"model \"llama3.2:3b\" not found, try pulling it first"}"`