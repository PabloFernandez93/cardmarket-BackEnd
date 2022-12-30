package com.example.cardmarket.repository;

import com.example.cardmarket.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {}
