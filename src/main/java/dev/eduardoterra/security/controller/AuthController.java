package dev.eduardoterra.security.controller;

import dev.eduardoterra.security.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.eduardoterra.security.dto.request.LoginRequest;
import dev.eduardoterra.security.dto.request.RegisterUserRequest;
import dev.eduardoterra.security.dto.response.LoginResponse;
import dev.eduardoterra.security.dto.response.RegisterUserResponse;
import dev.eduardoterra.security.repository.UserRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {
    
    private final UserRepository userRepository;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request){
        return null;
    }

    public ResponseEntity<RegisterUserResponse> register(@Valid @RequestBody RegisterUserRequest request){
        User newUSer = new User();
        newUSer.setPassword(request.password());
        newUSer.setEmail(request.email());
        newUSer.setName(request.name());
        
        userRepository.save(newUSer);
        return ResponseEntity.status(HttpStatus.CREATED).body(new RegisterUserResponse(newUSer.getName(), newUSer.getEmail()));
    }


}
