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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    private int availability;

    private int edition;

    @OneToMany(mappedBy = "pokemon") //types
    private List<Card> cards;

}
