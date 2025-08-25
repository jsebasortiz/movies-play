package com.movies.movies_play.domain.service;

import com.movies.movies_play.domain.dto.MovieDto;
import com.movies.movies_play.domain.repository.MovieRepository;
import com.movies.movies_play.persistence.entity.MovieEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<MovieDto> getAll() {
        return this.movieRepository.getAll();
    }
    public MovieDto getById(long id) {
        return this.movieRepository.getById(id);
    }

    public MovieDto add(MovieDto movieDto) {
        return this.movieRepository.save(movieDto);
    }

}
