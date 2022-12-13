package com.example.cardmarket.entity;


import com.example.cardmarket.enums.Condition;
import com.example.cardmarket.enums.Rarity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter


public class Article {

    @Id
    @GeneratedValue
    private Long id;

    private String condition;

    private String language;

    private String print;

    @ManyToOne
    private Card card;


}
