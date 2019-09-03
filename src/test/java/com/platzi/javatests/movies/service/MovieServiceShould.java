package com.platzi.javatests.movies.service;

import com.platzi.javatests.movies.data.MovieRepository;
import com.platzi.javatests.movies.model.Genre;
import com.platzi.javatests.movies.model.Movie;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MovieServiceShould {
    private MovieService movieService;
    @Before
    public void setUp() throws Exception {
        MovieRepository movieRepository = Mockito.mock(MovieRepository.class);
        Mockito.when(movieRepository.findAll()).thenReturn(
                Arrays.asList(
                        new Movie(1,"Dark Knight", 152, Genre.ACTION),
                        new Movie(2,"Memento", 113, Genre.THRILLER),
                        new Movie(3,"There's Something about Mary", 119, Genre.COMEDY),
                        new Movie(4,"Super 8", 112, Genre.THRILLER),
                        new Movie(5,"Scream", 111, Genre.HORROR),
                        new Movie(6,"Home Alone", 103, Genre.COMEDY),
                        new Movie(7,"Matrix", 136, Genre.ACTION),
                        new Movie(8,"Star Wars Cap I", 166, Genre.ACTION),
                        new Movie(9,"Star Wars Cap II", 180, Genre.ACTION),
                        new Movie(10,"Star Wars Cap III", 156, Genre.ACTION),
                        new Movie(11,"Star Wars Cap IV", 176, Genre.ACTION),
                        new Movie(12,"Star Wars Cap V", 160, Genre.ACTION),
                        new Movie(13,"Star Wars Cap VI", 150, Genre.ACTION)
                )
        );
        movieService = new MovieService(movieRepository);
    }

    @Test
    public void return_movies_by_genre() {

        Collection<Movie> movies = movieService.findMoviesByGenre(Genre.COMEDY);

        assertThat(getMoviesIds(movies), is(Arrays.asList(3,6)));
    }

    @Test
    public void return_movies_by_length() {
        Collection<Movie> movies = movieService.findMoviesByLenght(119);

        assertThat(getMoviesIds(movies), is(Arrays.asList(2,3,4,5,6)));

    }

    private List<Integer> getMoviesIds(Collection<Movie> movies) {
        return movies.stream().map(Movie::getId).collect(Collectors.toList());
    }

    @Test
    public void return_movies_by_template_genre_and_minutes() {
        Movie template = new Movie(null, 150, Genre.ACTION);
        assertThat(getMoviesIds(movieService.findMoviesByTemplate(template)), is(Arrays.asList(7,13)) );
    }

    @Test
    public void return_movies_by_template_name_and_minutes() {
        Movie template = new Movie("Star", 160, null);
        assertThat(getMoviesIds(movieService.findMoviesByTemplate(template)), is(Arrays.asList(10,12,13)) );
    }
    @Test
    public void return_movies_by_template_name_and_genre() {
        Movie template = new Movie("Star", null, Genre.ACTION);
        assertThat(getMoviesIds(movieService.findMoviesByTemplate(template)), is(Arrays.asList(8,9,10,11,12,13)) );
    }

    @Test
    public void return_movies_by_template_null() {
        Movie template = new Movie(null, null, null);
        assertThat(getMoviesIds(movieService.findMoviesByTemplate(template)), is(Arrays.asList()) );
    }
}