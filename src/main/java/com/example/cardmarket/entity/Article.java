package com.example.cardmarket.entity;


import com.example.cardmarket.enums.Condition;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
public class Article {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private Condition condition;

    private String language;

    private Long price;

    @ManyToOne
    @JsonIgnoreProperties("articles")
    @JsonBackReference
//    @JoinColumn(name = "card_id", referencedColumnName = "id")
    private Card card;


}
