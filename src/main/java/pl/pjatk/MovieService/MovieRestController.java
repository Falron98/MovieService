package pl.pjatk.MovieService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.MovieService.Movie.Movie;
import pl.pjatk.MovieService.MovieService.MovieService;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieRestController {

    private MovieService movieService;

    public MovieRestController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getMovies(){ return ResponseEntity.ok(movieService.getAllMovies()); }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable("id") int movieId){
        return ResponseEntity.ok(movieService.getMovie(movieId));
    }

    @PostMapping
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie){
        return ResponseEntity.ok(movieService.addMovie(movie));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable(value = "id") int movieId,
            @RequestBody Movie movie){
        return ResponseEntity.ok(movieService.updateMovie(movieId, movie));
    }
}
