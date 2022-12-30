package com.example.cardmarket.service;

import com.example.cardmarket.entity.Card;
import com.example.cardmarket.repository.CardRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Random;

@Service
public class CardService {

    private CardRepository cardRepository;

    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public List<Card> getAll() {
        return this.cardRepository.findAll();
    }

    public Card getRandomCard() {
        Random rand = new Random();
        long upperBound = this.cardRepository.findAll().size();
        long randomLong = rand.nextLong(upperBound) +1;
        return this.cardRepository.findById(randomLong).get();
    }
}
