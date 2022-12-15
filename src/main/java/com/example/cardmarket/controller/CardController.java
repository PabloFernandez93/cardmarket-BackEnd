package com.example.cardmarket.controller;

import com.example.cardmarket.entity.Card;
import com.example.cardmarket.service.CardService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cardmarket/cards")
@CrossOrigin("http://localhost:4200")
public class CardController {

    private CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping
    public List<Card> getAllCards() {
        return this.cardService.getAll();
    }

    @GetMapping("/{id}")
    public Card findById(@PathVariable Long id) {
        return cardService.findById(id);
    }
}
