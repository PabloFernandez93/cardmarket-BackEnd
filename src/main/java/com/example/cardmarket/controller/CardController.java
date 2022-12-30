package com.example.cardmarket.controller;

import com.example.cardmarket.entity.Card;
import com.example.cardmarket.service.CardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
    public ResponseEntity<List<Card>> getAllCards() {
        return ResponseEntity.ok(cardService.getAll());
    }

    @GetMapping("/random")
    public ResponseEntity<Card> getRandomCard() {
        return ResponseEntity.ok(cardService.getRandomCard());
    }
}
