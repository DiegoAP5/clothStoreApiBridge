package com.example.cloth.dtos;


import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    String name;

    String email;

    String password;

    String cardNumber;

    String role;
}
