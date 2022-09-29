package com.emrealkan.restapiforkotlin.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;

    private String date ;

    private String directorName;

    private String movieImgUrl;

    private String movieDetail;


    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.REFRESH})
    @JoinTable(name = "movie_movie_categories",joinColumns = @JoinColumn(name = "movie_id"),inverseJoinColumns = @JoinColumn(name = "category_id"))
    @JsonIgnore
    private List<MovieCategory> movieCategories = new ArrayList<>();



}
