# spring-ai-ollama - Chat with Advisors

_**Note**: To keep the examples lightweight and easy to get quick response we are using the simplest model "**llama3.2:3b**"_

Application to demonstrate the Spring AI - Advisors to intercept, modify, and enhance AI-driven interactions.

We will be using three kinds of implementation here
- Logging (custom) Advisor
- SafeGuardAdvisor (built-in) Advisor (Sensitive words: "datasets", "human", "developed")
- Mixed advisors Logging + SafeGuardAdvisor

## Running the Application 
### Pre-requisite
- Make sure you have at least 3GB of memory for Docker.

### Run Command
```
mvn spring-boot:run
```
It takes a little time when you first start the application. 
When you **first run** the above command the application with pull the docker image of _Ollama_ and pull the _llama3.2:3b_ modal into Ollama. 

### Usage 1 - Logging Advisor
cURL - Logging Advisor
```
curl --location --request GET 'http://localhost:8080/springai/ollama/advisors/logging' \
--header 'Content-Type: text/plain' \
--data-raw 'What is chatGPT? Limit to 50 words'
```
You will see the logs of prompt Before and After in the logs.

### Usage 2 - SafeGuard Advisor
**Note:** Safeguard words are defined in the `OllamaConfig.java` currently **"datasets"**, **"human"**, **"developed"** are configured as non-safe words.

cURL - SafeGuard Advisor - Stopping scenario
```
curl --location --request GET 'http://localhost:8080/springai/ollama/advisors/safeguard' \
--header 'Content-Type: text/plain' \
--data-raw 'Is chatgpt a human'
```
You will get a response
```
I'm unable to respond to that due to sensitive content. Could we rephrase or discuss something else?
```

cURL - SafeGuard Advisor - Passing scenario
```
curl --location --request GET 'http://localhost:8080/springai/ollama/advisors/safeguard' \
--header 'Content-Type: text/plain' \
--data-raw 'What is the capital of UK'
```
You will get a response from the model

### Usage 2 - Mixed Advisors

cURL - SafeGuard + Logging Advisor - Stopping scenario
```
curl --location --request GET 'http://localhost:8080/springai/ollama/advisors/mixed-advisors' \
--header 'Content-Type: text/plain' \
--data-raw 'Is chatgpt a human'
```
You will see BEFORE and AFTER logs and also get a response
```
I'm unable to respond to that due to sensitive content. Could we rephrase or discuss something else?
```

cURL - SafeGuard Advisor - Passing scenario
```
curl --location --request GET 'http://localhost:8080/springai/ollama/advisors/safeguard' \
--header 'Content-Type: text/plain' \
--data-raw 'What is the capital of UK'
```
You will see BEFORE and AFTER logs and also a response from the model
