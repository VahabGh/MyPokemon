package com.ghamari.vahab.pokemon.main.view.pokemondetail;

import com.ghamari.vahab.pokemon.main.model.Pokemon;
import com.ghamari.vahab.pokemon.main.view.BaseView;

/**
 * Created by VahabGh on 5/28/2019.
 */
public interface PokemonDetailView<T> extends BaseView<T> {
    void setPokemonDetail(Pokemon pokemon);
    void onFailed(String exception);
}
