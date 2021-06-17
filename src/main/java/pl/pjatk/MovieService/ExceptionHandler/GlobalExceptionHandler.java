package pl.pjatk.MovieService.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.pjatk.MovieService.Exception.BadRequestException;
import pl.pjatk.MovieService.Exception.InternalServerErrorException;
import pl.pjatk.MovieService.Exception.MovieNotFoundException;

public class GlobalExceptionHandler {

    @ExceptionHandler(value = MovieNotFoundException.class)
    public ResponseEntity<Void> handleMovieNotFoundException(MovieNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @ExceptionHandler(value = BadRequestException.class)
    public ResponseEntity<Void> handleBadRequestException(BadRequestException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @ExceptionHandler(value = InternalServerErrorException.class)
    public ResponseEntity<Void> handleInternalServerErrorException
            (InternalServerErrorException exception) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
