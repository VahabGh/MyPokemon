package com.ghamari.vahab.pokemon.main.model;

import com.ghamari.vahab.pokemon.main.model.pokemondetail.PokemonDetailItem;
import com.ghamari.vahab.pokemon.main.model.pokemondetail.PokemonDetailItemType;
import com.google.gson.annotations.SerializedName;

public class AbilityInfo extends PokemonDetailItem {

    @SerializedName("ability")
    private Ability ability;

    @SerializedName("slot")
    private String slot;

    @SerializedName("is_hidden")
    private boolean isHidden;

    public class Ability
    {
        @SerializedName("name")
        private String name;

        public String getName() {
            return name;
        }
    }

    public boolean isHidden() {
        return isHidden;
    }

    public Ability getAbility() {
        return ability;
    }

    public String getSlot() {
        return slot;
    }

    @Override
    public PokemonDetailItemType getType() {
        return PokemonDetailItemType.POKEMON_ABILITY;
    }

}
