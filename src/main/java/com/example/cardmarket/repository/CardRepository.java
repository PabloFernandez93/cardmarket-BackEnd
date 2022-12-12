package com.example.cardmarket.repository;

import com.example.cardmarket.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CardRepository extends JpaRepository<Card, Integer> {
}
