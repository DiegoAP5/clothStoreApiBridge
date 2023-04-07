package com.example.cloth.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UpdateRefundRequest {

    private Long id;

    @NotBlank
    private String status;

    private String declaration;
}
