package com.ghamari.vahab.pokemon.main.view.pokemons;

import com.ghamari.vahab.pokemon.main.model.Pokemon;
import com.ghamari.vahab.pokemon.main.view.BaseView;

import java.util.List;

/**
 * Created by VahabGh on 5/28/2019.
 */
public interface PokemonsView<T> extends BaseView<T> {
    void success(String nextPage,List<Pokemon> pokemons);
    void failed(String data);
}
