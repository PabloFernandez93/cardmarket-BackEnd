package com.example.cardmarket.controller;
import com.example.cardmarket.entity.Article;
import com.example.cardmarket.service.ArticleService;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/cardmarket/api")
public class ArticleController {

    private ArticleService articleService;
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    //  get card by id
    @GetMapping("/card/{id}")
    public Article findById(@PathVariable int id) {
        return articleService.findById(id);
    }

    //  get all cards
    @GetMapping("/cards")
    public List<Article> getCards() {
        return articleService.findAll();
    }

    //  add card
    @PostMapping("/postcard")
    public void addCard(@RequestBody Article article) {
        articleService.add(article);
    }

    //  add list of cards
    @PostMapping("/cards")
    public void addCards(@RequestBody List<Article> articles) {
        articleService.addCards(articles);
    }

    //  delete card by id
    @DeleteMapping("/delete/{id}")
    public void deleteCard (@PathVariable int id) {
        articleService.deleteCard(id);
    }

//    @PutMapping("/{id}")
//    public Card updateCard(@PathVariable int id, @RequestBody Card card) {
//        Card foundCard = cardService.findById(id);
//        foundCard.setPrice(card.getPrice());
//        foundCard.setCondition(card.getCondition());
//        foundCard.setLanguage(card.getLanguage());
//        foundCard.setPrint(card.getPrint());
//    }






}
