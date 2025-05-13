# spring-ai-ollama - RAG - Vector Store as File

_**Note**: To keep the examples lightweight and easy to get quick response we are using the simplest model "**mxbai-embed-large**"_

Application to demonstrate the Spring AI - RAG - Using vector store as file (`SimpleVectorStore`).

## How the application works
- A PDF Company Profile file that was created purely based on a dummy company name whose information doesn't exit in the Model
- When the application start it reads the PDF file from the resources folded to generate the vector embedding and persist the vector store to a file in the application folder `vector-store.json`
- When we send a basic prompt to the Model requesting about the dummy company it will reply back with information found.
- When we send a prompt along with the RAG context (i.e. the vector store) Model will respond back with proper information that is in the PDF file.

## Running the Application 
### Pre-requisite
- Make sure you have at least 3GB of memory for Docker.

### Run Command
```
mvn spring-boot:run
```
It takes a little time when you first start the application. 
When you **first run** the above command the application with pull the docker image of _Ollama_ and pull the _mxbai-embed-large_ modal into Ollama. 

### Usage

#### Functional API's
##### cURL - Scenario 1: Basic prompt without providing the RAG context.
```
curl --location --request GET 'http://localhost:8080/springai/ollama/rag/file/without-rag' \
--header 'Content-Type: text/plain' \
--data-raw 'What is CrystalComABC?'
```
Response:
- As of my last update in October 2023, there is no widely recognized entity... etc.

##### cURL - Scenario 2: Basic prompt with providing the RAG context.
```
curl --location --request GET 'http://localhost:8080/springai/ollama/rag/file/with-rag' \
--header 'Content-Type: text/plain' \
--data-raw 'What is CrystalComABC?'
```
**Note:** You can open the company profile PDF file in the resources file and ask question based on the that.
Response:
- You will now start getting the information about the dummy company.

##### cURL - Scenario 3: Basic prompt with providing the RAG context. More detailed question
```
curl --location --request GET 'http://localhost:8080/springai/ollama/rag/file/with-rag' \
--header 'Content-Type: text/plain' \
--data-raw 'What is revene of CrystalComABC in 2009?'
```
Response:
- This will give information from a Financial Overview table in the PDF.

