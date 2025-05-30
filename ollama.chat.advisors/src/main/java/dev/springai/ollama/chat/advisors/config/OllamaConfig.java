package dev.springai.ollama.chat.advisors.config;

import dev.springai.ollama.chat.advisors.advisor.LoggingAdvisor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SafeGuardAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OllamaConfig {

    @Bean
    public ChatClient loggingAdvisorChatClient(ChatClient.Builder chatClientBuilder) {
        return chatClientBuilder.defaultAdvisors(
                new LoggingAdvisor()
        ).build();
    }

    @Bean
    public ChatClient safeGuardAdvisorChatClient(ChatClient.Builder chatClientBuilder) {
        return chatClientBuilder.defaultAdvisors(
               new SafeGuardAdvisor(List.of("datasets", "human", "developed"))
        ).build();
    }

    @Bean
    public ChatClient mixedAdvisorChatClient(ChatClient.Builder chatClientBuilder) {
        return chatClientBuilder.defaultAdvisors(
                new LoggingAdvisor(),
                SafeGuardAdvisor.builder()
                        .sensitiveWords(List.of("datasets", "human", "developed"))
                        .order(1) // we want to make sure logging advisor always get triggered first.
                        .build()
        ).build();
    }
}
