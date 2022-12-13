package com.example.cardmarket.service;

import com.example.cardmarket.entity.Card;
import com.example.cardmarket.repository.CardRepository;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
@Getter
@Setter
public class CardService {

    private CardRepository cardRepository;

    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public Iterable<Card> getAllPokemon() {
        return this.cardRepository.findAll();
    }
}
