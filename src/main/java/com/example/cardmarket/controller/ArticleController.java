package com.example.cardmarket.controller;

import com.example.cardmarket.entity.Article;
import com.example.cardmarket.service.ArticleService;
import jakarta.validation.Valid;
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

    @GetMapping("/{id}")
    public ResponseEntity<Article> findById(@PathVariable Long id) {
        return articleService.findById(id)
                .map(article -> ResponseEntity.ok(article))
                .orElse(ResponseEntity.noContent().build());
    }

    @GetMapping
    public ResponseEntity<List<Article>> getArticles() {
        return ResponseEntity.ok(articleService.findAll());
    }


    @GetMapping("/all/{id}")
    public ResponseEntity<List<Article>> getArticleByCardId(@PathVariable long id) {
        return ResponseEntity.ok(articleService.findAllByCardId(id));
    }

    @PostMapping
    public ResponseEntity<Article> addCard(@RequestBody @Valid Article article) {
        if (article.getId() != null) {
            return ResponseEntity.badRequest().build();
        }
        articleService.add(article);
        return ResponseEntity.ok(article);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCard(@PathVariable Long id) {
        if (articleService.findById(id).isPresent()) {
            articleService.deleteArticle(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping
    public ResponseEntity<Article> updateArticle(@RequestBody @Valid Article article) {
        if (article.getId() == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(articleService.updateArticle(article));
    }
}
