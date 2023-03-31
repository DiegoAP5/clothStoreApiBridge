package com.example.cloth.security;

import com.example.cloth.dtos.AuntenticationRequest;
import com.example.cloth.dtos.AuntenticationRespons;
import com.example.cloth.dtos.RegisterRequest;
import com.example.cloth.entities.RoleEnum;
import com.example.cloth.entities.User;
import com.example.cloth.repositories.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final IUserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuntenticationRespons register(RegisterRequest request) {
        User user = User.builder()
                .email(request.getEmail())
                .role(RoleEnum.ADMIN)
                .name(request.getName())
                .cardNumber(request.getCardNumber())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();
        repository.save(user);

        Map<String, Object> payload = new HashMap<>();
        payload.put("roles", RoleEnum.ADMIN);

        var jwtToken = jwtService.generateToken(payload, user);
        return AuntenticationRespons.builder()
                .token(jwtToken)
                .build();
    }

    public AuntenticationRespons authenticate(AuntenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = repository.findByEmail(request.getEmail())
                .orElseThrow();

        Map<String, Object> payload = new HashMap<>();
        payload.put("roles", RoleEnum.ADMIN);

        var jwtToken = jwtService.generateToken(payload, user);
        return AuntenticationRespons.builder()
                .token(jwtToken)
                .build();
    }
}
