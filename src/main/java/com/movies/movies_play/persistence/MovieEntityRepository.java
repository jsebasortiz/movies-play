package com.movies.movies_play.persistence;

import com.movies.movies_play.domain.dto.MovieDto;
import com.movies.movies_play.domain.repository.MovieRepository;
import com.movies.movies_play.persistence.crud.CrudMovieEntity;
import com.movies.movies_play.persistence.mapper.MovieMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieEntityRepository implements MovieRepository {
    private final CrudMovieEntity crudMovieEntity;
    private final MovieMapper movieMapper;

    public MovieEntityRepository(CrudMovieEntity crudMovieEntity, MovieMapper movieMapper) {
        this.crudMovieEntity = crudMovieEntity;
        this.movieMapper = movieMapper;
    }

    @Override
    public List<MovieDto> getAll() {
        return this.movieMapper.toDto(crudMovieEntity.findAll());
    }
}

