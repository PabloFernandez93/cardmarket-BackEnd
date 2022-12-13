package com.example.cardmarket.entity;

import com.example.cardmarket.enums.CardType;
import com.example.cardmarket.enums.Rarity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String serialnumber; //für die Kartenbezeichnung im jeweiligen Set, z.B. 01-102

    private String name;

    private String type;

    private int availability;

    private String set;

    private String rarity;

    @OneToMany(mappedBy = "card")
    @JsonIgnoreProperties("card")
    private List<Article> articles;

}
