package com.example.cloth.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

@AllArgsConstructor
@Getter
@ToString
public class CreateEvent implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String message;
}
