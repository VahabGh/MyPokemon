package com.ghamari.vahab.pokemon.main.model;

import com.ghamari.vahab.pokemon.main.model.pokemondetail.PokemonDetailItem;
import com.ghamari.vahab.pokemon.main.model.pokemondetail.PokemonDetailItemType;

/**
 * Created by VahabGh on 5/29/2019.
 */
public class PokemonInfo extends PokemonDetailItem {

    private String name;
    private int height;
    private int weight;
    private int baseExprience;
    private String url;

    public PokemonInfo(String name, int height, int weight, int baseExprience, String url) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.baseExprience = baseExprience;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public int getBaseExprience() {
        return baseExprience;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public PokemonDetailItemType getType() {
        return PokemonDetailItemType.POKEMON_INFO;
    }
}
