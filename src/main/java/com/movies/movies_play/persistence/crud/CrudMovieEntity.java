package com.movies.movies_play.persistence.crud;

import com.movies.movies_play.persistence.entity.MovieEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudMovieEntity extends CrudRepository<MovieEntity, Long> {


}
