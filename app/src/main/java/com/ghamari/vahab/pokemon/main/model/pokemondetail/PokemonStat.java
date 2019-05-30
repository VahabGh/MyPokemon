package com.ghamari.vahab.pokemon.main.model.pokemondetail;

/**
 * Created by VahabGh on 5/29/2019.
 */
public class PokemonStat extends PokemonDetailItem {

    private String key;
    private String value;

    public PokemonStat(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    @Override
    public PokemonDetailItemType getType() {
        return PokemonDetailItemType.POKEMON_STAT;
    }
}
