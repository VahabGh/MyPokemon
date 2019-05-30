package com.ghamari.vahab.pokemon.main.model.webservice;

public interface PokemonNetwork<T> {
    void onResponse(T response);
    void onFailure(String exp);
}
