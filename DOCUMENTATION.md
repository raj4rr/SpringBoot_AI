# Agent Architecture Documentation

This document explains the internal architecture and codebase of the Ollama Spring Boot Agent. This agent is built to provide an API over a locally hosted large language model (LLM).

## Overview
The project is built using:
* **Java 21**
* **Spring Boot (v4.1.1)**: To provide the web server and application context.
* **Spring AI (v2.0.1)**: To interface seamlessly with the Ollama model without needing raw HTTP clients.
* **Ollama**: The underlying engine running the `qwen2.5:1.5b` model locally.

## Project Structure & Flow

### 1. Dependencies (`pom.xml`)
The two most critical dependencies powering this agent are:
* `spring-boot-starter-webmvc`: Provides the web server (Tomcat) and REST capabilities (like `@RestController` and `@GetMapping`).
* `spring-ai-starter-model-ollama`: Brings in Spring AI's auto-configuration specific to Ollama. It automatically wires up the connection to `localhost:11434`.

### 2. Configuration (`application.properties`)
Spring AI requires zero boilerplate for setup because of these properties:
```ini
# Connects to the local Ollama instance port
spring.ai.ollama.base-url=http://localhost:11434

# Tells Spring AI which model it should ask Ollama to use
spring.ai.ollama.chat.options.model=qwen2.5:1.5b
```
When Spring Boot starts up, it reads this and automatically constructs an `OllamaChatModel` bean in the background.

### 3. The API Layer (`ChatController.java`)
This is the heart of the agent. The controller uses Spring AI's `ChatClient` (a fluent API for interacting with models). 

It exposes two endpoints:

**Standard Chat (`/chat`)**:
```java
@GetMapping("/chat")
public String chat(@RequestParam(value = "message", defaultValue = "Tell me a joke") String message) {
    return chatClient.prompt()
            .user(message)
            .call()       // Blocks the thread until the entire response is generated
            .content();   // Extracts just the text content of the response
}
```

**Streaming Chat (`/stream`)**:
```java
@GetMapping("/stream")
public Flux<String> streamChat(@RequestParam(value = "message", defaultValue = "Tell me a joke") String message) {
    return chatClient.prompt()
            .user(message)
            .stream()     // Returns a reactive Flux stream 
            .content();   // Pushes chunks (tokens) of text back to the client as they are generated
}
```
*Note: The streaming endpoint uses `Flux<String>`, which leverages Project Reactor. This allows the API to pipe data directly to the client as soon as Ollama generates a word, drastically reducing perceived latency.*

### 4. Agent Capabilities (Tool Calling)
This application operates as a true AI Agent because of its autonomous tool calling capabilities:

* **Tool Calling**: We created a `currentDateTime` method in `ChatController` and annotated it with `@Tool(description = "...")`. By adding `.defaultTools(this)` to the `ChatClient.Builder`, the LLM can autonomously decide to execute this Java method to retrieve the real-world date and time when the user asks for it.

## How it All Connects
1. The user hits `http://localhost:8081/chat?message=What time is it?` (Spring Boot Web).
2. The `ChatController` intercepts it and passes the prompt to `ChatClient`.
3. `ChatClient` asks Ollama. Ollama recognizes it needs the time and returns a "tool call" request.
4. Spring AI intercepts the tool call, executes the `currentDateTime` Java method behind the scenes, and sends the result back to Ollama.
5. Ollama generates the final text answer based on the real time.
6. Spring AI parses the response and returns the string back to the user via the HTTP response.
