package com.emrealkan.restapiforkotlin.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;


    @ManyToMany(mappedBy = "movieCategories")
    @JsonIgnore
    private List<Movie> movies = new ArrayList<>();


    public void addMovie(Movie movie){
        this.movies.add(movie);
    }



}
