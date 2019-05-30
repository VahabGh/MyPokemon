package com.ghamari.vahab.pokemon.main.model.pokemondetail;

import com.ghamari.vahab.pokemon.main.model.pokemondetail.PokemonDetailItem;
import com.ghamari.vahab.pokemon.main.model.pokemondetail.PokemonDetailItemType;

/**
 * Created by VahabGh on 5/29/2019.
 */
public class PokemonAbility extends PokemonDetailItem {

    private String name;
    private boolean isHidden;
    private int slot;

    public PokemonAbility(String name, boolean isHidden, int slot) {
        this.name = name;
        this.isHidden = isHidden;
        this.slot = slot;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isHidden() {
        return isHidden;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    @Override
    public PokemonDetailItemType getType() {
        return PokemonDetailItemType.POKEMON_ABILITY;
    }
}
