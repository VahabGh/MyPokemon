package com.ghamari.vahab.pokemon.main.presenter;

import com.ghamari.vahab.pokemon.main.model.PokemonData;
import com.ghamari.vahab.pokemon.main.model.RequestClass;
import com.ghamari.vahab.pokemon.main.model.webservice.PokemonNetwork;
import com.ghamari.vahab.pokemon.main.view.pokemons.PokemonsView;

/**
 * Created by VahabGh on 5/28/2019.
 */
public class PokemonsPresenter {

    private PokemonsView view;
    private PokemonData data;

    public void getAllPokemons() {
        if (data == null) {
            view.showProgress();
            RequestClass.getAllPokemons(new PokemonNetwork<PokemonData>() {
                @Override
                public void onResponse(PokemonData response) {
                    if (response != null) {
                        view.success(response.getNext(), response.getPokemonList());
                        data = response;
                    } else
                        view.failed("failed");
                }

                @Override
                public void onFailure(String exp) {
                    view.failed("failed");
                }
            });
        } else
            view.success(data.getNext(), data.getPokemonList());
    }


    public void setView(PokemonsView view) {
        this.view = view;
    }
}
