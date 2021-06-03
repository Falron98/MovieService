package pl.pjatk.MovieService.ExceptionHandler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.pjatk.MovieService.Exception.MovieNotFoundException;

public class GlobalExceptionHandler {

    @ExceptionHandler(value = MovieNotFoundException.class)
    public ResponseEntity<Void> handleMovieNotFoundException(MovieNotFoundException exception) {
        return ResponseEntity.notFound().build();
    }
}
