package dev.springai.ollama.chat.converters.map.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.converter.MapOutputConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OllamaConfig {

    @Bean
    public ChatClient chatClient(ChatClient.Builder chatClientBuilder) {
        return chatClientBuilder.build();
    }

    @Bean
    public MapOutputConverter mapOutputConverter() {
       return new MapOutputConverter();
    }

}
