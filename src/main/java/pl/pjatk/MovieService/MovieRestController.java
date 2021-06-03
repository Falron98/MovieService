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

    private final MovieService movieService;

    public MovieRestController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> getMovies(){ return ResponseEntity.ok(movieService.getMovieList()); }

    @GetMapping("/movies/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable("id") Long movieId){
        return ResponseEntity.ok(movieService.findById(movieId));
    }

    @PostMapping("/movies")
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie){
        return ResponseEntity.ok(movieService.addMovie(movie));
    }

    @PutMapping("/movies/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable(value = "id") Long Id,
            @RequestBody Movie movie){
        return ResponseEntity.ok(movieService.updateMovie(Id, movie));
    }

    @DeleteMapping("/movies/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable("id") Long id){
        movieService.deleteById(id);
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/movies/true/{id}")
    public ResponseEntity<Movie> updateMovieAvailable(@PathVariable("id") Long id){
        return ResponseEntity.ok(movieService.updateMovieAvailable(id));
    }



}
