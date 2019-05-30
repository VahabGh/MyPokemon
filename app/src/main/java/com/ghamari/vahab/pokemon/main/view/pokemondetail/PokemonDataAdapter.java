package com.ghamari.vahab.pokemon.main.view.pokemondetail;

import com.ghamari.vahab.pokemon.main.model.Pokemon;
import com.ghamari.vahab.pokemon.main.model.pokemondetail.AbilityHeader;
import com.ghamari.vahab.pokemon.main.model.pokemondetail.InfoHeader;
import com.ghamari.vahab.pokemon.main.model.pokemondetail.StatHeader;
import com.ghamari.vahab.pokemon.main.model.pokemondetail.PokemonDetailItem;
import com.ghamari.vahab.pokemon.main.model.pokemondetail.PokemonInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by VahabGh on 5/29/2019.
 */
public class PokemonDataAdapter {

    public static List<PokemonDetailItem> adapt(Pokemon pokemon) {
        List<PokemonDetailItem> items = new ArrayList<>();

        if (pokemon == null)
            return items;

        items.add(new InfoHeader());
        items.add(makePokemonInfo(pokemon));

        if (pokemon.getAbilities() != null) {
            items.add(new AbilityHeader());
            items.addAll(pokemon.getAbilities());
        }

        if (pokemon.getStatInfos() != null) {
            items.add(new StatHeader());
            items.addAll(pokemon.getStatInfos());
        }

        return items;
    }

    private static PokemonDetailItem makePokemonInfo(Pokemon pokemon) {
        return new PokemonInfo(pokemon.getName(),
                pokemon.getHeight(),
                pokemon.getWeight(),
                pokemon.getBaseExperience(),
                pokemon.getSptrites().getFront());

    }
}
