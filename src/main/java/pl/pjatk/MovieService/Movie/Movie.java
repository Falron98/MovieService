package pl.pjatk.MovieService.Movie;


import javax.persistence.*;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String Name;

    @Enumerated(EnumType.STRING)
    private Category category;

    private Boolean isAvailable=false;

    public Movie() {

    }

    public Movie(Long id, String name, Category category) {
        Id = id;
        Name = name;
        this.category = category;
    }

    public enum Category{
        Horror,
        Comedy,
        Fantasy,
        Action
    }

    public Long getId() {
        return Id;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
