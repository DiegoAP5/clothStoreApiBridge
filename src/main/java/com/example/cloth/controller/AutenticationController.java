package com.example.cloth.controller;

import com.example.cloth.dtos.AuntenticationRequest;
import com.example.cloth.dtos.AuntenticationRespons;
import com.example.cloth.dtos.RegisterRequest;
import com.example.cloth.security.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AutenticationController {

    private final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<AuntenticationRespons> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/token")
    public ResponseEntity<AuntenticationRespons> authenticate(@RequestBody AuntenticationRequest request){
        return ResponseEntity.ok(service.authenticate(request));
    }
}
