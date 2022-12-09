package com.example.cardmarket.repository;

import com.example.cardmarket.entity.Pokemon;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonRepository extends CrudRepository<Pokemon, Integer> {

}
