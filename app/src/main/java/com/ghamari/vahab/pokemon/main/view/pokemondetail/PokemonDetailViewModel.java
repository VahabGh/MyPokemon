package com.ghamari.vahab.pokemon.main.view.pokemondetail;

import android.arch.lifecycle.ViewModel;

import com.ghamari.vahab.pokemon.main.presenter.PokemonDetailPresenter;

public class PokemonDetailViewModel extends ViewModel {

    PokemonDetailPresenter pokemonDetailPresenter;

    public PokemonDetailViewModel() {
        this.pokemonDetailPresenter = new PokemonDetailPresenter();
    }
}
