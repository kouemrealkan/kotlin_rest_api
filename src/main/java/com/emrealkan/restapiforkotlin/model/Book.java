package com.emrealkan.restapiforkotlin.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;

    private Long isbnNumber;

    private String name;

    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(name = "book_types",joinColumns = {@JoinColumn(name = "book_id")},inverseJoinColumns = {@JoinColumn(name = "type_id")})
    private List<BookType> bookTypes = new ArrayList<>();


}
