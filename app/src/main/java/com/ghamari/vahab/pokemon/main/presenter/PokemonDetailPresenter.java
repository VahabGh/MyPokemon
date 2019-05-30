package com.ghamari.vahab.pokemon.main.presenter;

import com.ghamari.vahab.pokemon.main.model.Pokemon;
import com.ghamari.vahab.pokemon.main.model.RequestClass;
import com.ghamari.vahab.pokemon.main.model.webservice.PokemonNetwork;
import com.ghamari.vahab.pokemon.main.view.pokemondetail.PokemonDetailView;

/**
 * Created by VahabGh on 5/28/2019.
 */
public class PokemonDetailPresenter {

    private PokemonDetailView view;
    private Pokemon data;

    public void setView(PokemonDetailView view) {
        this.view = view;
    }

    public void getPokemonDetail(String pokemonUrl) {
        if (data == null) {
            view.showProgress();
            RequestClass.getPokemonByIt(getIdFromUrl(pokemonUrl), new PokemonNetwork<Pokemon>() {
                @Override
                public void onResponse(Pokemon response) {
                    if (response != null) {
                        view.setPokemonDetail(response);
                        data = response;
                    } else
                        view.onFailed("data is null");

                }

                @Override
                public void onFailure(String exp) {
                    view.onFailed(exp);
                }
            });
        } else
            view.setPokemonDetail(data);

    }

    private int getIdFromUrl(String pokemonUrl) {
        String[] items = pokemonUrl.split("/");
        return Integer.parseInt(items[items.length - 1]);
    }
}
