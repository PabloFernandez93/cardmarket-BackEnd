package com.example.cardmarket.entity;

import com.example.cardmarket.enums.Condition;
import com.example.cardmarket.enums.Language;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Condition condition;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Language language;

    @DecimalMin("0.01")
    @DecimalMax("9999.99")
    @NotNull
//    @Pattern(regexp = "\^([\\d]{0,4})(\\.|$)([\\d]{1,2}|)$")
    private double price;

    @ManyToOne
    @JsonIgnoreProperties("articles")
    private Card card;

}
