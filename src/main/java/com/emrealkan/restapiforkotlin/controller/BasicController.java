package com.emrealkan.restapiforkotlin.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/home")
@AllArgsConstructor
public class BasicController {



    @GetMapping("/home-page")
    public ResponseEntity<String> home(){
        return ResponseEntity.ok().body("APP HOME PAGE!");
    }

}
