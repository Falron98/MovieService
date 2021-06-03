package pl.pjatk.MovieService.MovieService;


import org.springframework.stereotype.Service;
import pl.pjatk.MovieService.Exception.MovieNotFoundException;
import pl.pjatk.MovieService.Movie.Movie;
import pl.pjatk.MovieService.Repository.MovieRepository;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    public Movie findById(Long id) {
        return movieRepository.findById(id)
                .orElseThrow(MovieNotFoundException::new);

    }

    public List<Movie> getMovieList() {
        return movieRepository.findAll();
    }

    public Movie addMovie(Movie movie){
        return movieRepository.save(movie);
    }

    public Movie updateMovie(Long Id, Movie movie){
        Movie movieUpdate = movieRepository.getOne(Id);
        movieUpdate.setName(movie.getName());
        movieUpdate.setCategory(movie.getCategory());
        movieUpdate.setAvailable(true);
        return movieRepository.save(movieUpdate);
    }

    public void deleteById(Long id){
        movieRepository.deleteById(id);
    }

    public Movie updateMovieAvailable(Long Id){
        Movie movieUpdate = movieRepository.getOne(Id);
        movieUpdate.setAvailable(true);
        return movieRepository.save(movieUpdate);
    }


}
