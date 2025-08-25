package com.movies.movies_play.domain.dto;

import com.movies.movies_play.domain.Genre;

public record MovieDto(String title, Integer duration, Genre genre, String releaseDate, Double rating, String status) {

}
