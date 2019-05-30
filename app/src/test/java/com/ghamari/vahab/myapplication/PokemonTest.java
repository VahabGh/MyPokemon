package com.ghamari.vahab.myapplication;

import com.ghamari.vahab.pokemon.main.model.Pokemon;
import com.ghamari.vahab.pokemon.main.presenter.PokemonDetailPresenter;
import com.ghamari.vahab.pokemon.main.view.pokemondetail.PokemonDetailView;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PokemonTest implements PokemonDetailView {

    @Test
    public void get_data() {
        createPresenter().getPokemonDetail("https://pokeapi.co/api/v2/pokemon/1/");
    }

    @Override
    public void setPokemonDetail(Pokemon pokemon) {
        assertTrue(pokemonIsValid(pokemon));
    }

    private boolean pokemonIsValid(Pokemon pokemon) {
        return pokemon != null ;
    }

    @Override
    public void onFailed(String exception) {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public PokemonDetailPresenter createPresenter() {
        return new PokemonDetailPresenter(this);
    }
}
