package dev.springai.ollama.rag.file;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
public class SpringAiOllamaRagFileApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAiOllamaRagFileApplication.class, args);
	}

}
