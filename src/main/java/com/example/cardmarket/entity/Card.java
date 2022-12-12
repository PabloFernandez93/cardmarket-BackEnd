package com.example.cardmarket.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Card {

    @Id
    @GeneratedValue
    private Long id;

    private double price;

    private String condition;

    private String language;

    private String print;

    @ManyToOne
    private Pokemon pokemon;



}
