package com.example.cardmarket;

import com.example.cardmarket.service.ArticleService;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CardmarketApplication implements CommandLineRunner {

	private ArticleService articleService;

	public CardmarketApplication(ArticleService articleService) {
		this.articleService = articleService;
	}


	public static void main(String[] args) {
		SpringApplication.run(CardmarketApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		this.articleService.findAll().forEach(article -> this.articleService.updateAvailability(article));
	}
}
