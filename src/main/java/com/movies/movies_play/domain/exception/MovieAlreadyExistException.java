package com.movies.movies_play.domain.exception;

public class MovieAlreadyExistException extends RuntimeException {

    public MovieAlreadyExistException(String movieTitle) {
        super("La película con el título '" + movieTitle + "' ya existe.");
    }

}
