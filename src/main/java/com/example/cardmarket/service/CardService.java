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

    public Iterable<Card> getAll() {
        return this.cardRepository.findAll();
    }

    public Card findById(int id) {return this.cardRepository.findById(id).get();}
}
