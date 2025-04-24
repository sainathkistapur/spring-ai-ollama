package dev.springai.ollama.basic.chat.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/springai/ollama/basic-chat")
@RequiredArgsConstructor
public class BasicChatController {

    private final ChatClient chatClient;

    @GetMapping()
    public String basicChat(@RequestBody String prompt) {
        return chatClient.prompt(prompt).call().content();
    }
}