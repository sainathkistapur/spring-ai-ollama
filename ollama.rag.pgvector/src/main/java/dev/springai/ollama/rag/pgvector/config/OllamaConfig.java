package dev.springai.ollama.rag.pgvector.config;


import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.vectorstore.QuestionAnswerAdvisor;
import org.springframework.ai.rag.advisor.RetrievalAugmentationAdvisor;
import org.springframework.ai.rag.generation.augmentation.ContextualQueryAugmenter;
import org.springframework.ai.rag.retrieval.search.VectorStoreDocumentRetriever;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OllamaConfig {

    @Bean
    public ChatClient basicChatClient(ChatClient.Builder chatClientBuilder) {
        return chatClientBuilder.build();
    }


    @Bean
    public ChatClient ragChatClientWithQaAdvisor(ChatClient.Builder chatClientBuilder, VectorStore vectorStore) {
        return chatClientBuilder
                .defaultAdvisors(
                        QuestionAnswerAdvisor.builder(vectorStore).build())
                .build();
    }


    @Bean
    public ChatClient ragChatClientWithRagAdvisor(ChatClient.Builder chatClientBuilder, VectorStore vectorStore) {
        return chatClientBuilder
                .defaultAdvisors(
                        RetrievalAugmentationAdvisor.builder()
                                .documentRetriever(VectorStoreDocumentRetriever.builder()
                                        .vectorStore(vectorStore)
                                        .build()).queryAugmenter(
                                        ContextualQueryAugmenter.builder()
                                                .allowEmptyContext(true)
                                                .build())
                                .build()
                )
                .build();
    }


}

