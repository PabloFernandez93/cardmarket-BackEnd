package com.example.cardmarket.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Pokemon {
//dawdawd
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name = "pokemonId")
    private int pokemonId;

    @Column(name = "name")
    private String name;

    @Column(name = "avalaibility")
    private int avalaibility;

    @Column(name = "rarity")
    private String rarity;

    @Column(name = "edition")
    private int edition;

    @OneToMany(mappedBy = "pokemon")
    private List<Card> cards;

}
