package com.ghamari.vahab.pokemon.main.model.webservice;

import com.ghamari.vahab.pokemon.main.model.Pokemon;
import com.ghamari.vahab.pokemon.main.model.PokemonData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GetDataService {

    @GET("pokemon")
    Call<PokemonData> getAllPokemons();

    @GET("pokemon")
    Call<PokemonData> getAllPokemons(@Query("offset") String offset, @Query("limit") String limit);

    @GET("pokemon/{id}")
    Call<Pokemon> getPokemonById(@Path("id") int id);
}
