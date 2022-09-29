package com.emrealkan.restapiforkotlin.service;

import com.emrealkan.restapiforkotlin.dto.*;
import com.emrealkan.restapiforkotlin.exceptions.AppException;
import com.emrealkan.restapiforkotlin.mapper.UserMapper;
import com.emrealkan.restapiforkotlin.model.User;
import com.emrealkan.restapiforkotlin.repository.UserRepository;
import com.emrealkan.restapiforkotlin.security.JwtValidator;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.Instant;

@Service
@AllArgsConstructor
@Transactional
public class AuthService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final UserMapper userMapper;
    private final JwtValidator jwtValidator;

    private final Path root = Paths.get("uploads");


    public void init(){
        try {
            Files.createDirectory(root);
        }catch (IOException e){
            throw new RuntimeException("Could not initialize folder for upload!");
        }
    }

    @Transactional
    public void registerUser(@RequestParam(value = "file") MultipartFile multipartFile, RegisterRequest registerRequest) {
        User user =  new User();
        user.setUserName(registerRequest.getUserName());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setRole("ROLE_USER");
        user.setCreatedDate(Instant.now());
        user.setProfileImgUrl(multipartFile.getOriginalFilename());
        userRepository.save(user);
    }

    public AuthResponse login(LoginRequest loginRequest){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUserName(),loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtValidator.generateAuthToken(authentication);
        User authUser = userRepository.findByUserName(loginRequest.getUserName())
                .orElseThrow(()->new AppException("user not found"));
        // Authentication authUser = SecurityContextHolder.getContext().getAuthentication();
        // LinkedHashMap<String,Object> prop = (LinkedHashMap<String, Object>) authUser.getDetails();
        // String userEmail = prop.get("email").toString();
        //authTokenService.registerAuthToken(token);

        return AuthResponse.builder()
                .authToken(token)
                .expiresAt(Instant.now().plusMillis(jwtValidator.getJwtExpirationInMillis()))
                .userName(loginRequest.getUserName())
                .role(authUser.getRole())
                .build();



    }

    @Transactional(readOnly = true)
    public UserResponse getCurrentUser(){
        Jwt principal = (Jwt) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User getUser  = userRepository.findByUserName(principal.getSubject())
                .orElseThrow(()->new AppException("user not found"));
        return userMapper.mapToDto(getUser);
    }

    public LogoutResponse userLogout(){
        SecurityContextHolder.getContext().setAuthentication(null);
        return LogoutResponse.builder()
                .message("Logout Success !")
                .build();
    }





}
