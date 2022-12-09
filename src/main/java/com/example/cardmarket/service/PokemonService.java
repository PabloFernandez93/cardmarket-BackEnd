package com.example.cardmarket.service;

import com.example.cardmarket.entity.Pokemon;
import com.example.cardmarket.repository.PokemonRepository;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
@Getter
@Setter
public class PokemonService {

    private PokemonRepository pokemonRepository;

    public PokemonService(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    public Iterable<Pokemon> getAllPokemon() {
        return this.pokemonRepository.findAll();
    }
}
