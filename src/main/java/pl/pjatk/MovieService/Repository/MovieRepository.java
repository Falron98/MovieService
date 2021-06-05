package pl.pjatk.MovieService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pjatk.MovieService.Movie.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
