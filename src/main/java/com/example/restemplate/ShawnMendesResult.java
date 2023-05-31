package com.example.restemplate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ShawnMendesResult(String trackName,
                                String artistName) {
}
