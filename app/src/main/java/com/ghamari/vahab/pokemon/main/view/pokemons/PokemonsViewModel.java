package com.ghamari.vahab.pokemon.main.view.pokemons;


import android.arch.lifecycle.ViewModel;

import com.ghamari.vahab.pokemon.main.presenter.PokemonsPresenter;

public class PokemonsViewModel extends ViewModel {

    PokemonsPresenter pokemonsPresenter;

    public PokemonsViewModel() {
        pokemonsPresenter = new PokemonsPresenter();
    }
}
