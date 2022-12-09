package com.example.cardmarket.controller;
import com.example.cardmarket.entity.Card;
import com.example.cardmarket.service.CardService;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/cardmarket/api")
public class CardController {

    private CardService cardService;
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    //  get card by id
    @GetMapping("/card/{id}")
    public Card findById(@PathVariable int id) {
        return cardService.findById(id);
    }

    //  get all cards
    @GetMapping("/cards")
    public List<Card> getCards() {
        return cardService.findAll();
    }

    //  add card
    @PostMapping("/postcard")
    public void addCard(@RequestBody Card card) {
        cardService.add(card);
    }

    //  add list of cards
    @PostMapping("/cards")
    public void addCards(@RequestBody List<Card> cards) {
        cardService.addCards(cards);
    }

    //  delete card by id
    @DeleteMapping("/delete/{id}")
    public void deleteCard (@PathVariable int id) {
        cardService.deleteCard(id);
    }

    @PutMapping("/{id}")
    public Card updateCard(@PathVariable int id, @RequestBody Card card) {
        Card foundCard = cardService.findById(id);
        foundCard.setPrice(card.getPrice());
        foundCard.setCondition(card.getCondition());
        foundCard.setLanguage(card.getLanguage());
        foundCard.setPrint(card.getPrint());
    }






}
