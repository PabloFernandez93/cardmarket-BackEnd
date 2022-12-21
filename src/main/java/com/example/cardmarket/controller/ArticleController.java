package com.example.cardmarket.controller;
import com.example.cardmarket.entity.Article;
import com.example.cardmarket.service.ArticleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/cardmarket/article")
@CrossOrigin("http://localhost:4200")
public class ArticleController {

    private ArticleService articleService;
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    //  get card by id
    @GetMapping("/{id}")
    public Article findById(@PathVariable Long id) {
        return articleService.findById(id);
    }

    //  get all cards
    @GetMapping
    public List<Article> getCards() {
        return articleService.findAll();
    }

    //  add card
    @PostMapping
    public void addCard(@RequestBody Article article) {
        articleService.add(article);
    }

    //  add list of cards
    @PostMapping("/list")
    public void addCards(@RequestBody List<Article> articles) {
        articleService.addArticles(articles);
    }

    //  delete card by id
    @DeleteMapping("/delete/{id}")
    public void deleteCard (@PathVariable Long id) {
        articleService.deleteArticle(id);
    }

    @PutMapping
    public ResponseEntity<Article> updateArticle(@RequestBody Article article) {
        if (article.getId() == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(articleService.updateArticle(article));
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
