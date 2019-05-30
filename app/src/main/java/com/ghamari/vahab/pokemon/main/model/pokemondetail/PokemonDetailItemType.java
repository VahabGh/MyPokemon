package com.ghamari.vahab.pokemon.main.model.pokemondetail;

/**
 * Created by VahabGh on 5/28/2019.
 */
public enum PokemonDetailItemType {
    POKEMON_STAT(0), POKEMON_INFO(1), POKEMON_ABILITY(2), STAT_HEADER(3),ABILITY_HEADER(4),INFO_HEADER(5);

    private int id;

    PokemonDetailItemType(int id) {
        this.id = id;
    }

    public int id() {
        return id;
    }
}
