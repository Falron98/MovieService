package pl.pjatk.MovieService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pjatk.MovieService.Movie.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    Optional<Movie> findById(Long aLong);

    List<Movie> findAll();

    void deleteById(Long aLong);

    <S extends Movie> S save(S entity);

    Movie getOne(Long aLong);
}
