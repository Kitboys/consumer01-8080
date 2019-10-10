package com.example.consumer.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
public class Depart {
    private Integer id;
    private String name;
    private String dbase;
}
