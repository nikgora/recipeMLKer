package com.example.recipemlker.service.impl;
//https://medium.com/technology-hits/how-to-integrate-openai-into-a-spring-boot-application-using-spring-ai-05b4c6b753dc
import com.azure.ai.openai.OpenAIClient;
import com.example.recipemlker.model.Recipe;
import com.example.recipemlker.service.AIService;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.client.AiClient;//change to 0.8.1 version
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.chat.prompt.SystemPromptTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AiServiceImpl implements AIService {
    private final AiClient chatClient;

    @Override
    public String isOkToPublish(Recipe recipe) {
        String userText = "";
        PromptTemplate userPromptTemplate = new PromptTemplate(userText);
        Message userMessage = userPromptTemplate.createMessage(Map.of("language", "english", "topic", topic));

        String systemText = """
                You are a helpful AI assistant that helps students in practicing foreign languages. Respond in the style of an encouraging teacher
                """;
        SystemPromptTemplate systemPromptTemplate = new SystemPromptTemplate(systemText);

        Message systemMessage = systemPromptTemplate.createMessage();

        Prompt prompt = new Prompt(List.of(userMessage, systemMessage));
        return chatClient.(prompt).getGeneration().getText();
    }
}
