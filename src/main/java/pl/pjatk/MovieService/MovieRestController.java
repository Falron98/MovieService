package pl.pjatk.MovieService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.MovieService.Exception.BadRequestException;
import pl.pjatk.MovieService.Movie.Movie;
import pl.pjatk.MovieService.MovieService.MovieService;
import java.util.List;

@Service
@RestController
@RequestMapping("/movies/")
public class MovieRestController {

    private final MovieService movieService;

    public MovieRestController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("")
    public ResponseEntity<List<Movie>> getMovies(){ return ResponseEntity.ok(movieService.getMovieList()); }

    @GetMapping("get/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable("id") Long movieId){
        return ResponseEntity.ok(movieService.getMovieById(movieId));
    }

    @PostMapping("")
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie){
        return ResponseEntity.ok(movieService.addMovie(movie));
    }

    @PutMapping("{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable(value = "id") Long Id,
            @RequestBody Movie movie){
        return ResponseEntity.ok(movieService.updateMovie(Id, movie));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable("id") Long id){
        movieService.deleteById(id);
        return ResponseEntity.notFound().build();
    }

    @PutMapping("true/{id}")
    public ResponseEntity<Movie> updateMovieAvailable(@PathVariable("id") Long id){
        return ResponseEntity.ok(movieService.updateMovieAvailable(id));
    }

    @GetMapping("test")
    public void test(){
        movieService.test();
    }
    @GetMapping("test2")
    public void test2(){
        movieService.test2();
    }
    @GetMapping("test3")
    public void test3(){
        movieService.test3();
    }



}
