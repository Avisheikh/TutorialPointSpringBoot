package com.example.DTO.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookSlimDto
{
    @JsonProperty("id")
    private int id;

    @JsonProperty("title")
    private String title;
}
