package com.example.cardmarket.controller;

import com.example.cardmarket.entity.Pokemon;
import com.example.cardmarket.service.PokemonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pokemon/api")

public class PokemonController {

    private PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("/getall")
    public List<Pokemon> getAllPokemon() {
        return (List<Pokemon>) this.pokemonService.getAllPokemon();
    }


}
