package com.example.cardmarket.controller;

import com.example.cardmarket.entity.Card;
import com.example.cardmarket.service.CardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cardmarket/card")

public class CardController {

    private CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping("/getall")
    public List<Card> getAllPokemon() {
        return (List<Card>) this.cardService.getAllPokemon();
    }


}
