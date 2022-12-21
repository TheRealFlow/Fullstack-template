package com.example.backend;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class Movie {
    private int id;
    private String name;
    private int year;
    private String imgURL;
}
