package com.codewithmosh.store.controllers;

import com.codewithmosh.store.dtos.JwtResponse;
import com.codewithmosh.store.dtos.LoginRequest;
import com.codewithmosh.store.repositories.UserRepository;
import com.codewithmosh.store.services.JwtService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final JwtService jwtService;
    //    private PasswordEncoder passwordEncoder;
//    private UserRepository userRepository;
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(
        @Valid @RequestBody LoginRequest request
    ){
//        var user = userRepository.findByEmail(request.getEmail()).orElse(null);
//        if(user == null){
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//        }
//
//        if(!passwordEncoder.matches(request.getPassword(), user.getPassword())){
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//        }

        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                    request.getEmail(),
                    request.getPassword()
            )
        );

        var token = jwtService.generateToken(request.getEmail());

        return ResponseEntity.ok(new JwtResponse(token));
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<Void> UnauthorizedErrorHandler(){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}
