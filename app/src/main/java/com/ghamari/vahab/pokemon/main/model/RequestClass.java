package com.ghamari.vahab.pokemon.main.model;

import com.ghamari.vahab.pokemon.main.model.webservice.GetDataService;
import com.ghamari.vahab.pokemon.main.model.webservice.PokemonNetwork;
import com.ghamari.vahab.pokemon.main.model.webservice.RetrofitClientInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RequestClass {

    public static void getPokemonByIt(int id, final PokemonNetwork<Pokemon> pokemonPokemonNetwork)
    {
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<Pokemon> call = service.getPokemonById(id);
        call.enqueue(new Callback<Pokemon>() {
            @Override
            public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                if (response.isSuccessful())
                    pokemonPokemonNetwork.onResponse(response.body());
                else
                    pokemonPokemonNetwork.onFailure("is failed");
            }

            @Override
            public void onFailure(Call<Pokemon> call, Throwable t) {
                pokemonPokemonNetwork.onFailure("is failed");
            }
        });
    }

    public static void getAllPokemons(final PokemonNetwork<PokemonData> pokemonPokemonNetwork)
    {
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<PokemonData> call = service.getAllPokemons();
        call.enqueue(new Callback<PokemonData>() {
            @Override
            public void onResponse(Call<PokemonData> call, Response<PokemonData> response) {
                if (response.isSuccessful())
                    pokemonPokemonNetwork.onResponse(response.body());
                else
                    pokemonPokemonNetwork.onFailure("is failed");
            }

            @Override
            public void onFailure(Call<PokemonData> call, Throwable t) {
                pokemonPokemonNetwork.onFailure("is failed");
            }
        });
    }


    public static void getAllPokemons(final PokemonNetwork<PokemonData> pokemonPokemonNetwork,String offset,String limit)
    {
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<PokemonData> call = service.getAllPokemons(offset, limit);
        call.enqueue(new Callback<PokemonData>() {
            @Override
            public void onResponse(Call<PokemonData> call, Response<PokemonData> response) {
                if (response.isSuccessful())
                    pokemonPokemonNetwork.onResponse(response.body());
                else
                    pokemonPokemonNetwork.onFailure("is failed");
            }

            @Override
            public void onFailure(Call<PokemonData> call, Throwable t) {
                pokemonPokemonNetwork.onFailure("is failed");
            }
        });
    }

}
