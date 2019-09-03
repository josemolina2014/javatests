package com.platzi.javatests.movies.service;

import com.platzi.javatests.movies.data.MovieRepository;
import com.platzi.javatests.movies.model.Genre;
import com.platzi.javatests.movies.model.Movie;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MovieService {

    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Collection<Movie> findMoviesByGenre(Genre genre)
    {
        return movieRepository.findAll().stream()
                .filter( movie -> movie.getGenre() == genre)
                .collect(Collectors.toList());
    }

    public Collection<Movie> findMoviesByLenght(int length) {
        return movieRepository.findAll().stream()
                .filter( movie -> movie.getMinutes() <= length)
                .collect(Collectors.toList());
    }
    public Collection<Movie> findMoviesByName(String name) {
        return movieRepository.findAll().stream()
                .filter( movie -> movie.getName().contains(name))
                .collect(Collectors.toList());
    }

    public Collection<Movie> findMoviesByTemplate1(Movie template){

        if(template.getMinutes()==null || template.getMinutes()<0 ) {
            throw new IllegalArgumentException("Los minutos no pueder ser negativos");
        }

        Collection<Movie> result = new ArrayList<>();


        if ((template.getMinutes()!=null)&&(template.getGenre()!=null) && (template.getName()!=null))
        {
            result = movieRepository.findAll().stream()
                    .filter( movie -> movie.getMinutes() <= template.getMinutes())
                    .filter( movie -> movie.getGenre() == template.getGenre())
                    .filter( movie -> movie.getName().contains(template.getName()))
                    .collect(Collectors.toList());
        }
        else if ((template.getMinutes()==null)&&(template.getGenre()!=null) && (template.getName()!=null))
        {
            result = movieRepository.findAll().stream()
                    .filter( movie -> movie.getGenre() == template.getGenre())
                    .filter( movie -> movie.getName().contains(template.getName()))
                    .collect(Collectors.toList());

        }
        else if ((template.getMinutes()!=null)&&(template.getGenre()==null) && (template.getName()!=null))
        {
            result = movieRepository.findAll().stream()
                    .filter( movie -> movie.getMinutes() <= template.getMinutes())
                    .filter( movie -> movie.getName().contains(template.getName()))
                    .collect(Collectors.toList());
        }
        else if ((template.getMinutes()!=null)&&(template.getGenre()!=null) && (template.getName()==null))
        {
            result = movieRepository.findAll().stream()
                    .filter( movie -> movie.getMinutes() <= template.getMinutes())
                    .filter( movie -> movie.getGenre() == template.getGenre())
                    .collect(Collectors.toList());
        }

        return result;
    }

    public Collection<Movie> findMoviesByTemplate(Movie template){

        Predicate<Movie> finalPredicate= null;

        if(template.getName()!=null)
        {
            Predicate<Movie> namePredicate =   movie -> movie.getName().contains(template.getName());
            finalPredicate = finalPredicate==null?namePredicate:finalPredicate.and(namePredicate);
        }
        if(template.getGenre()!=null)
        {
            Predicate<Movie> genrePredicate =  movie -> movie.getGenre() == template.getGenre();
            finalPredicate = finalPredicate==null?genrePredicate:finalPredicate.and(genrePredicate);
        }
        if(template.getMinutes()!=null)
        {
            Predicate<Movie> minutePredicate = movie -> movie.getMinutes() <= template.getMinutes();
            finalPredicate = finalPredicate==null?minutePredicate:finalPredicate.and(minutePredicate);
        }
        if(template.getDirector()!=null)
        {
            Predicate<Movie> directorPredicate = movie -> movie.getDirector().contains(template.getDirector());
            finalPredicate = finalPredicate==null?directorPredicate:finalPredicate.and(directorPredicate);
        }

        if(finalPredicate==null)
            return new ArrayList<>();

        return  movieRepository.findAll().stream().filter(finalPredicate).collect(Collectors.toList());

    }
}
