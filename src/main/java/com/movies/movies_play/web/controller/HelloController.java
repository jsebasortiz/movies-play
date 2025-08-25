package com.movies.movies_play.web.controller;

import com.movies.movies_play.domain.service.MoviesPlayAiService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private final MoviesPlayAiService aiService;
    private final String plataform;

    public HelloController(@Value("${spring.application.name}") String plataform, MoviesPlayAiService aiService) {
        this.aiService = aiService;
        this.plataform = plataform;
    }

    @GetMapping("/hello")
    public String hello() {
        return this.aiService.generateGreeting(plataform);
    }
}

