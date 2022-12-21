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
    public ResponseEntity<Article> findById(@PathVariable Long id) {
        return articleService.findById(id)
                .map(article -> ResponseEntity.ok(article))
                .orElse(ResponseEntity.noContent().build());
    }

    //  get all cards
    @GetMapping
    public ResponseEntity<List<Article>> getCards() {
        return ResponseEntity.ok(articleService.findAll());
    }

    //  add card
    @PostMapping
    public ResponseEntity<Article> addCard(@RequestBody Article article) {
        if (article.getId() != null) {
            return ResponseEntity.badRequest().build();
        }
        articleService.add(article);
        return ResponseEntity.ok(article);
    }

//    //  add list of cards
//    @PostMapping("/list")
//    public void addCards(@RequestBody List<Article> articles) {
//        articleService.addArticles(articles);
//    }

    //  delete card by id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCard (@PathVariable Long id) {
        articleService.deleteArticle(id);
        return ResponseEntity.ok().build();

    }

    @PutMapping
    public ResponseEntity<Article> updateArticle(@RequestBody Article article) {
        if (article.getId() == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(articleService.updateArticle(article));
    }








}
