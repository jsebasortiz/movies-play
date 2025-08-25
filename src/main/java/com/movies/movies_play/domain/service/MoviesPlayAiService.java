package com.movies.movies_play.domain.service;

import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
import dev.langchain4j.service.spring.AiService;

@AiService
public interface MoviesPlayAiService {

    @UserMessage("""
            Genera un saludo de bienvenida a la plataforma de Gestion de peliculas {{plataform}}.
            Usa menos de 120 caracteres y hazlo con el estilo de Imbd.
            """)
    String generateGreeting(@V("plataform") String plataform);
}