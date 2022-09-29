package com.emrealkan.restapiforkotlin.controller;


import com.emrealkan.restapiforkotlin.dto.*;
import com.emrealkan.restapiforkotlin.helper.ImageUploadHelper;
import com.emrealkan.restapiforkotlin.service.AuthService;
import com.nimbusds.jose.proc.SecurityContext;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import static org.springframework.http.ResponseEntity.status;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;

    @Autowired
    private final ImageUploadHelper imageUploadHelper;


    @PostMapping("/file-demo")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file){
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getSize());

        try {
            boolean f=  imageUploadHelper.uploadFile(file);
            if(f){
                return new ResponseEntity<>("IMAGE UPLOAD SUCCESS",HttpStatus.OK);
            }

        }catch (Exception e){
            e.printStackTrace();
        }


        return new ResponseEntity<>("SOME WENT WRONG",HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @PostMapping(value = "/register",consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<String> registerUser(MultipartFile file,RegisterRequest registerRequest){
        try {
            boolean f=  imageUploadHelper.uploadFile(file);
            if(f){
                authService.registerUser(file,registerRequest);
                return new ResponseEntity<>("USER REGISTER SUCCESS",HttpStatus.OK);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return new ResponseEntity<>("User Registration FAIL", HttpStatus.OK);
    }

    @PostMapping("/login")
    public AuthResponse login(LoginRequest loginRequest){
        return authService.login(loginRequest);
    }

    @GetMapping("/user-info")
    public ResponseEntity<UserResponse> getUser(){
        return status(HttpStatus.OK).body(authService.getCurrentUser());
    }

    @PostMapping("/logout")
    public ResponseEntity<LogoutResponse> userLogout(){
       return ResponseEntity.status(HttpStatus.OK).body(authService.userLogout());
    }

}
