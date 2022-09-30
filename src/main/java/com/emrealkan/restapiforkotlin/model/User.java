package com.emrealkan.restapiforkotlin.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;


    private String email;

    private String role;

    private String password;

    private String profileImgUrl;

    private Instant createdDate;

    @OneToOne(mappedBy = "user")
    private ImageData imageData;


}
