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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "price")
    private double price;

    @Column(name = "condition")
    private String condition;

    @Column(name = "language")
    private String language;

    @Column(name = "print")
    private String print;


    @ManyToOne
    @JoinColumn(name = "pokemon_id")
    private Pokemon pokemon;



}
