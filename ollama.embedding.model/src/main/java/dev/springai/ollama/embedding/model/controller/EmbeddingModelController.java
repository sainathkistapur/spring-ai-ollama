package dev.springai.ollama.embedding.model.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.embedding.EmbeddingRequest;
import org.springframework.ai.embedding.EmbeddingResponse;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/springai/ollama/embedding")
@RequiredArgsConstructor()
public class EmbeddingModelController {

    private final EmbeddingModel embeddingModel;

    @GetMapping("/simple")
    public Map embed(@RequestBody String prompt) {
        EmbeddingResponse embeddingResponse = this.embeddingModel.embedForResponse(List.of(prompt));
        return Map.of("embedding", embeddingResponse);
    }

    @GetMapping("/custom")
    public Map customsEmbed(@RequestBody String prompt) {
        EmbeddingResponse embeddingResponse = this.embeddingModel.call(
                new EmbeddingRequest(List.of(prompt),
                OllamaOptions.builder()
                        .model("nomic-embed-text")
                        .build()));
        return Map.of("embedding", embeddingResponse);
    }
}
