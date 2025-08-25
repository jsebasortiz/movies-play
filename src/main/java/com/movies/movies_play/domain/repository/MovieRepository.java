package com.movies.movies_play.domain.repository;

import com.movies.movies_play.domain.dto.MovieDto;
import com.movies.movies_play.persistence.entity.MovieEntity;

import java.util.List;

public interface MovieRepository {
    List<MovieDto> getAll();

}
