package com.example.cardmarket.service;

import com.example.cardmarket.entity.Card;
import com.example.cardmarket.repository.CardRepository;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {

    private CardRepository cardRepository;

    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public List<Card> getAll() {
        return this.cardRepository.findAll();
    }

    public Card findById(Long id) {return this.cardRepository.findById(id).get();}
}
