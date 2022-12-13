package com.example.cardmarket.entity;

import com.example.cardmarket.enums.CardType;
import com.example.cardmarket.enums.Rarity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
//@Getter
//@Setter
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String serialNumber; //für die Kartenbezeichnung im jeweiligen Set, z.B. 01-102

    private String name;

    private CardType type;

    private int availability;

    private String set;

    private Rarity rarity;

    @OneToMany(mappedBy = "card")
    @JsonIgnoreProperties("card")
    private List<Article> articles;

}
