package com.example.cardmarket.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Pokemon { //CardType

    @Id
    @GeneratedValue
    private Long id;

    private String type;

    private int availability; //zu Card?

    private String rarity; //zu Card?

    private int edition; //zu Card?

    @OneToMany(mappedBy = "pokemon") //types
    private List<Card> cards;

}
