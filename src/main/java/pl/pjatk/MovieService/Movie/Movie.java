package pl.pjatk.MovieService.Movie;

public class Movie {

    private int MovieId;
    private String Name;
    private String Category;

    public Movie(int movieId, String name, String category) {
        MovieId = movieId;
        Name = name;
        Category = category;
    }

    public int getMovieId() {
        return MovieId;
    }

    public void setMovieId(int movieId) {
        MovieId = movieId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }
}
