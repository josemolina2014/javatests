package com.platzi.javatests.movies.data;

import com.platzi.javatests.movies.model.Genre;
import com.platzi.javatests.movies.model.Movie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

public class MovieRepositoryJdbc implements MovieRepository {

    private JdbcTemplate jdbcTemplate;

    public MovieRepositoryJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Movie findById(long id) {
        Object[] args = {id};
        return jdbcTemplate.queryForObject("select * from movies where id=?", args, movieMapper);
    }

    @Override
    public Collection<Movie> findAll() {

        return jdbcTemplate.query("select * from movies", movieMapper);
    }

    @Override
    public void saveOrUpdate(Movie movie) {
        jdbcTemplate.update("insert into movies (name, minutes, genre, director) values (?,?,?, ?)",
                movie.getName(), movie.getMinutes(), movie.getGenre().toString(), movie.getDirector());

    }

    private static  RowMapper<Movie> movieMapper = (rs, rowNum) ->
            new Movie(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getInt("minutes"),
                Genre.valueOf(rs.getString("genre")));

    public Collection<Movie> findByName(String matrix) {
        Object[] args = {"%"+matrix.toLowerCase()+"%"};
        return jdbcTemplate.query("select * from Movies where lower(name) like ?", args, movieMapper);
    }

    public Collection<Movie> findByDirector(String director) {
        Object[] args = {"%"+director.toLowerCase()+"%"};
        return jdbcTemplate.query("select * from Movies where lower(director) like ?", args, movieMapper);
    }
}
