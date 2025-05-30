package dev.springai.ollama.chat.memory.jdbc.memory.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/springai/ollama/chat/memory/jdbc-memory")
@RequiredArgsConstructor
public class JdbcMemoryChatController {

    private final ChatClient basicChatClient;

    private final ChatClient jdbcMemoryChatClient;

    @GetMapping("/prompt-with-no-memory")
    public String chatWithNoMemory(@RequestBody String prompt,
                                   @RequestHeader(value = "conversationId") String conversationId) {
        return basicChatClient.prompt(prompt).call().content();
    }

    @GetMapping("/prompt-with-jdbc-memory")
    public String chatWithJdbcMemory(@RequestBody String prompt,
                                     @RequestHeader(value = "conversationId") String conversationId) {
        return jdbcMemoryChatClient.prompt(prompt).advisors(
                advisorSpec -> advisorSpec.param(ChatMemory.CONVERSATION_ID, conversationId))
                .call().content();
    }

}
