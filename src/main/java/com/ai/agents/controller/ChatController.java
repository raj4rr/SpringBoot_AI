package com.ai.agents.controller;

import com.ai.agents.tools.WeatherTools;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import java.time.LocalDateTime;

@RestController
public class ChatController {

    private final ChatClient chatClient;
    @Autowired
    private WeatherTools weatherTools;
    public ChatController(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder
                .defaultTools(this)
                .build();
    }

    @Tool(description = "Get the current real-world date and time")
    public String currentDateTime() {
        return LocalDateTime.now().toString();
    }

    @GetMapping("/chat")
    public String chat(@RequestParam(value = "message", defaultValue = "Tell me a joke") String message) {
        return chatClient.prompt()
                .user(message)
                .call()
                .content();
    }

    @GetMapping("/chatAdvanced")
    public String chatAdvanced(@RequestParam(value = "message", defaultValue = "Tell me a joke") String message) {
        return chatClient.prompt()
                .user(message)
              //  .tools(new DateTimeTools())
                .tools(weatherTools)
                .call()
                .content();
    }

    @GetMapping("/stream")
    public Flux<String> streamChat(@RequestParam(value = "message", defaultValue = "Tell me a joke") String message) {
        return chatClient.prompt()
                .user(message)
                .stream()
                .content();
    }
}