package com.movies.movies_play.persistence;

import com.movies.movies_play.domain.dto.MovieDto;
import com.movies.movies_play.domain.dto.UpdateMovieDto;
import com.movies.movies_play.domain.exception.MovieAlreadyExistException;
import com.movies.movies_play.domain.exception.MovieNotFoundException;
import com.movies.movies_play.domain.repository.MovieRepository;
import com.movies.movies_play.persistence.crud.CrudMovieEntity;
import com.movies.movies_play.persistence.entity.MovieEntity;
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

    @Override
    public MovieDto getById(long id) {
        MovieEntity movieEntity = this.crudMovieEntity.findById(id).orElse(null);
        return this.movieMapper.toDto(movieEntity);
    }

    @Override
    public MovieDto save(MovieDto movieDto) {

        if (this.crudMovieEntity.findFirstByTitulo(movieDto.title()) != null) {
            throw new MovieAlreadyExistException(movieDto.title());
        }
        MovieEntity movieEntity = this.movieMapper.toEntity(movieDto);
        movieEntity.setEstado("D");

        return this.movieMapper.toDto(this.crudMovieEntity.save(movieEntity));
    }

    @Override
    public MovieDto update(Long id, UpdateMovieDto updateMovieDto) {
        MovieEntity movieEntity = this.crudMovieEntity.findById(id).orElse(null);

        if (movieEntity == null) {
            throw new MovieNotFoundException(id);
        }

        this.movieMapper.updateEntityFromDto(updateMovieDto, movieEntity);
        return this.movieMapper.toDto(crudMovieEntity.save(movieEntity));
    }

    @Override
    public MovieDto delete(Long id) {
        MovieEntity movieEntity = this.crudMovieEntity.findById(id).orElse(null);
        if (movieEntity == null) {
            throw new MovieNotFoundException(id);
        }

        movieEntity.setEstado("N");
        return this.movieMapper.toDto(this.crudMovieEntity.save(movieEntity));
    }
}
