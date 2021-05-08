package pl.pjatk.MovieService.MovieService;


import org.springframework.stereotype.Service;
import pl.pjatk.MovieService.Movie.Movie;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class MovieService {

    private int movieIdCount = 1;
    private final List<Movie> movieList = new CopyOnWriteArrayList<>();

    public List<Movie> getMovies(){ return movieList;}

    public List<Movie> getAllMovies(){
        Movie movie1 = new Movie(1, "IT", "Horror");
        Movie movie2 = new Movie(2, "IT2", "Horror");
        Movie movie3 = new Movie(3, "Deadpool", "Action");

        return List.of(movie1, movie2, movie3);
    }

    public Movie getMovie(int MovieId){
        Movie movie1 = new Movie(MovieId, "IT", "Horror");

        return movie1;
    }

    public Movie addMovie(Movie movie){
        movie.setMovieId(movieIdCount);
        movieIdCount++;
        movieList.add(movie);
        return movie;
    }

    public Movie updateMovie(int MovieId, Movie movie){

        movieList
                .stream()
                .forEach(c -> {
                    if(c.getMovieId() == MovieId){
                        c.setName(movie.getName());
                        c.setCategory(movie.getCategory());
                    }
                });
        return movieList
                .stream()
                .filter(c -> c.getMovieId() == MovieId)
                    .findFirst()
                    .get();

    }


}
