package com.ghamari.vahab.pokemon.main.model;

import com.ghamari.vahab.pokemon.main.model.pokemondetail.PokemonDetailItem;
import com.ghamari.vahab.pokemon.main.model.pokemondetail.PokemonDetailItemType;
import com.google.gson.annotations.SerializedName;

public class StatInfo extends PokemonDetailItem{
    @SerializedName("stat")
    private Stat stat;

    @SerializedName("base_stat")
    private String baseStat;

    public class Stat
    {
        @SerializedName("name")
        private String name;

        public String getName() {
            return name;
        }
    }

    public Stat getStat() {
        return stat;
    }

    public String getBaseStat() {
        return baseStat;
    }

    @Override
    public PokemonDetailItemType getType() {
        return PokemonDetailItemType.POKEMON_STAT;
    }
}
