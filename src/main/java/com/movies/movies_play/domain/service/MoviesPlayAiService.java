package com.movies.movies_play.domain.service;

import dev.langchain4j.service.SystemMessage;
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

    @SystemMessage("""
            Eres un experto en cine que recomienda películas personalizadas según los gustos del usuario.
            Debes recomendar máximo 3 películas.
            No incluyas películas que estén por fuera de la plataforma MoviesPlay.
            """)
    String generateMoviesSuggestion(@UserMessage String userMessage);
}