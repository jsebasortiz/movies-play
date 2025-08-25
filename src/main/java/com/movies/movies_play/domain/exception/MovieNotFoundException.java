package com.movies.movies_play.domain.exception;

public class MovieNotFoundException extends RuntimeException {

    public MovieNotFoundException(long id) {
        super("La película con el ID '" + id + "' no existe.");
    }

}
