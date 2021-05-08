package pl.pjatk.MovieService;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.MovieService.Movie.Movie;
import pl.pjatk.MovieService.MovieService.MovieService;
import java.util.List;

@Service
@RestController
public class MovieRestController {

    private MovieService movieService;

    public MovieRestController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> getMovies(){ return ResponseEntity.ok(movieService.getAllMovies()); }

    @GetMapping("/movies/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable("id") int movieId){
        return ResponseEntity.ok(movieService.getMovie(movieId));
    }

    @PostMapping("/movies")
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie){
        return ResponseEntity.ok(movieService.addMovie(movie));
    }

    @PutMapping("/movies/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable(value = "id") int movieId,
            @RequestBody Movie movie){
        return ResponseEntity.ok(movieService.updateMovie(movieId, movie));
    }

    @DeleteMapping("/movies/{id}")
    public ResponseEntity<Void> deleteMovie(){
        return ResponseEntity.noContent().build();
    }



}
