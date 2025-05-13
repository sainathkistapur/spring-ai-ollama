# spring-ai-ollama - RAG - Vector Store as pgVector

## Application to demonstrate the Spring AI - RAG Context using pgVector to store the vector embeddings.

## How the application works
- As the cutoff of the model that we are using is October 2023, it will not have the knowledge of UK Spring Statement 2025.
- A PDF version of the UK Spring Statement 2025 `HMT_Spring_Statement_2025.pdf` is stored in the resources folder.
- When the application start it reads the PDF file from the resources folded to generate the vector embedding and persist into pgVector DB.
- When we send a basic prompt to the Model requesting about UK Spring Statement 2025 it will reply back with information not found.
- When we send a prompt along with the RAG context (i.e. context from the vector store) Model will respond back with proper information that is in the PDF file.
    - In this scenario the application will first query the local pdVector DB to get the contextual information based on the user query.
    - Then the application will pass that information as a context to the Model to augment the response based on the context information.

### Type of prompts used
- Basic prompt - to show how the Model responds if it can't find the latest information.
- Prompt Template - to show how a Prompt Template can be used to achieved RAG
- QuestionAndAnswerAdvisor - to show the QuestionAndAnswerAdvisor internally queries the vector store and attached context to the prompt.
- RetrievalAugmentationAdvisor - to show purpose build RAG advisor can be used for RAG

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
curl --location --request GET 'http://localhost:8080/springai/ollama/rag/pgvector/without-rag-context' \
--header 'Content-Type: text/plain' \
--data-raw 'summaries Economic & Fiscal Outlook the SPRING STATEMENT 2025 UK'
```
Response:
- Similar response like: I'm sorry, but I can't provide a summary...

##### cURL - Scenario 2:  Prompt Template with providing the RAG context.
```
curl --location --request GET 'http://localhost:8080/springai/ollama/rag/pgvector/with-rag-prompt-template' \
--header 'Content-Type: text/plain' \
--data-raw 'what is the Public sector net financial liabilities1 in 2024 from SPRING STATEMENT 2025 UK'
```
**Note:** You can open the company profile PDF file in the resources file and ask question based on the that.
Response:
- You will now start getting the information based on the PDF file.

##### cURL - Scenario 3: QuestionAndAnswer Advisor with providing the RAG context.
```
curl --location --request GET 'http://localhost:8080/springai/ollama/rag/pgvector/with-rag-qa-advisor' \
--header 'Content-Type: text/plain' \
--data-raw 'what is the Public sector net financial liabilities1 in 2024 from SPRING STATEMENT 2025 UK'
```
Response:
- You will now start getting the information based on the PDF file.

##### cURL - Scenario 3: RetrievalAugmentation Advisor with providing the RAG context.
```
curl --location --request GET 'http://localhost:8080/springai/ollama/rag/pgvector/with-rag-rag-advisor' \
--header 'Content-Type: text/plain' \
--data-raw 'what is the Public sector net financial liabilities1 in 2024 from SPRING STATEMENT 2025 UK'
```
Response:
- You will now start getting the information based on the PDF file.
