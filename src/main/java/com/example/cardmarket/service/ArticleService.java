package com.example.cardmarket.service;

import com.example.cardmarket.entity.Article;
import com.example.cardmarket.repository.ArticleRepository;
import com.example.cardmarket.repository.CardRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ArticleService {

    private ArticleRepository articleRepository;
    private CardRepository cardRepository;

    public ArticleService(ArticleRepository articleRepository, CardRepository cardRepository) {
        this.articleRepository = articleRepository;
        this.cardRepository = cardRepository;
    }

    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    public Optional<Article> findById(Long id) {
        return articleRepository.findById(id);
    }

    public void add(Article article) {
        articleRepository.save(article);
        updateAvailability(article);
    }

    public void deleteArticle(Long id) {
        Optional<Article> optArticle = articleRepository.findById(id);
        articleRepository.deleteById(id);
        optArticle.ifPresent(article ->
                updateAvailability(article));
    }

    public Article updateArticle(Article article) {
        return articleRepository.save(article);
    }

    public void updateAvailability(Article article) {
        cardRepository.findById(
                        article.getCard().getId()
                )
                .ifPresent(card -> {
                    card.setAvailability(card.getArticles().size());
                    cardRepository.save(card);
                });
    }

    public List<Article> findAllByCardId(long id) {
        return this.articleRepository.findAll().stream()
                .filter(article -> article.getCard().getId() == id)
                .collect(Collectors.toList());
    }
}
