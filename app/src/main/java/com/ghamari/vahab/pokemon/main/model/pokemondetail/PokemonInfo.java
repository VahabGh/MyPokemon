package com.ghamari.vahab.pokemon.main.model.pokemondetail;

/**
 * Created by VahabGh on 5/29/2019.
 */
public class PokemonInfo extends PokemonDetailItem {

    private String name;
    private String height;
    private String weight;
    private String baseExprience;
    private String url;

    public PokemonInfo(String name, String height, String weight, String baseExprience, String url) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.baseExprience = baseExprience;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getHeight() {
        return height;
    }

    public String getWeight() {
        return weight;
    }

    public String getBaseExprience() {
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
