package com.movies.movies_play.web.exception;

import com.movies.movies_play.domain.exception.MovieAlreadyExistException;
import com.movies.movies_play.domain.exception.MovieNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(MovieAlreadyExistException.class)
    public ResponseEntity<Error> handleException(MovieAlreadyExistException ex) {
        Error error = new Error("Movie-Already-Exists", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(MovieNotFoundException.class)
    public ResponseEntity<Error> handleException(MovieNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Error("movie-not-found", e.getMessage()));

    }
}
