package com.ghamari.vahab.pokemon.main.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PokemonData {

    @SerializedName("next")
    private String next;

    @SerializedName("results")
    private List<Pokemon> pokemonList;

    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }

    public String getNext() {
        return next;
    }

}
