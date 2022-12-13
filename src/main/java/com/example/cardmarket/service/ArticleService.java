package com.example.cardmarket.service;
import com.example.cardmarket.entity.Article;
import com.example.cardmarket.repository.ArticleRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ArticleService {

    private ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public List<Article> findAll() {
        return (List<Article>) articleRepository.findAll();
    }

    public Article findById(int id) {
        return articleRepository.findById(id).get();
    }

    public void add(Article article) {
        articleRepository.save(article);
    }

    public void addCards(List<Article> articles) {
        articleRepository.saveAll(articles);
    }

    public void deleteCard(int id) {
        articleRepository.deleteById(id);
    }
}
