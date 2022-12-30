package com.example.cardmarket.entity;

import com.example.cardmarket.enums.CardType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String serialNumber;

    private String name;

    @Enumerated(EnumType.STRING)
    private CardType type;

    private int availability;

    private String cardSet;

    private String rarity;

    private String image;

    @OneToMany(mappedBy = "card")
    @JsonIgnoreProperties("card")
    private List<Article> articles;

}
