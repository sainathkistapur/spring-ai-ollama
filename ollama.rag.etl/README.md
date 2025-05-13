# spring-ai-ollama - RAG - ETL

_**Note**: To keep the examples lightweight and easy to get quick response we are using the simplest model "**mxbai-embed-large**"_

Application to demonstrate the Spring AI - RAG - ETL functionality

We will be using
- pgVector as the VectorStore
- Springboot Docker Compose support is used to set up the pgVector
- We are using only Json data for this example. But similar approach can be used for:

| Type          | Reader                     |
|---------------|----------------------------|
| Text          | TextReader                 |
| HTML          | JsoupDocumentReader        |
| Markdown      | MarkdownDocumentReader     |
| PDF           | PagePdfDocumentReader      |
| PDF Paragraph | ParagraphPdfDocumentReader |
| DOCX, PPT     | TikaDocumentReader         |


## Running the Application 
### Pre-requisite
- Make sure you have at least 3GB of memory for Docker.

### Run Command
```
mvn spring-boot:run
```
- It takes a little time when you first start the application. 
- When you **first run** the above command the application with pull the docker image of _Ollama_ and pull the _mxbai-embed-large_ modal into Ollama.
- When the application is started you should be able to browser the pgVector database using the details provided in the ```compose.yaml``` file.


### Usage
Though all the core functionality resides in the `JsonEtlPipelineService` and `MockDataJsonReader` there are convenient API's exposed to testing all the scenarios.

#### Utility API's
cURL - Get current vector table count.
```
curl --location --request GET 'http://localhost:8080/springai/ollama/rag/etl/json-etl/vector-count'
```

cURL - Delete all records in the vector db table.
```
curl --location --request DELETE 'http://localhost:8080/springai/ollama/rag/etl/json-etl/clear-vector'
```

#### Functional API's
##### cURL - Scenario 1: Json-ETL-Without-Transformer - ETL Pipeline: Reader -> Writer
```
curl --location --request GET 'http://localhost:8080/springai/ollama/rag/etl/json-etl/without-transformer'
```
Response:
- This will convert the data from the `resources/data/MOCK_DATA.json` into embeddings and stores in the `vector_store` table.
- You should get a number of records created in the vector store. The number will match with number of records in the `MOCK_DATA.json`
- You can verify and check the data in the `vector_store` table.

##### cURL - Scenario 2: Json-ETL-With-Transformer  - ETL Pipeline: Reader -> Transformer -> Writer
**Note:** Before running the below use the utilities API's to delete the existing records and verify the count is zero using the Get current vector table count API.
```
curl --location --request GET 'http://localhost:8080/springai/ollama/rag/etl/json-etl/with-transformer'
```
Response:
- You should get a number of records created in the vector store. The number will be twice the number of records in the `MOCK_DATA.json` as there is `TokenTextSplitter` used which splits each document into two chunks.
- You can verify and check the data in the `vector_store` table.
- You will notice that the `metadata` column in the database table has empty records `{}`

The below scenarios should only be used as coding examples as running these need a good amount of processing power
- Scenario 3: Json-ETL-With-Transformer-And-Keyword-Metadata-Enricher - ETL Pipeline: Reader -> Transformer -> Transformer -> Writer
- Scenario 4: Json-ETL-With-Transformer-And-Keyword-Metadata-And-Summary-Metadata-Enricher

