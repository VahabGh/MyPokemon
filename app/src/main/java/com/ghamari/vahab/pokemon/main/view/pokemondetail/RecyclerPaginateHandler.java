package com.ghamari.vahab.pokemon.main.view.pokemondetail;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ghamari.vahab.pokemon.main.model.PokemonData;
import com.ghamari.vahab.pokemon.main.model.RequestClass;
import com.ghamari.vahab.pokemon.main.model.webservice.PokemonNetwork;
import com.ghamari.vahab.pokemon.main.view.pokemons.PokemonsAdapter;

public class RecyclerPaginateHandler {

    private int limit = 20;
    private int offset = 0;
    private int listSize = 0;
    private PokemonsAdapter pokemonsAdapter;
    private RecyclerView recyclerView;
    private String nextPageUrl;
    private boolean isDataLoading = false;

    public RecyclerPaginateHandler(PokemonsAdapter pokemonsAdapter, RecyclerView recyclerView, String nextPageUrl) {
        this.pokemonsAdapter = pokemonsAdapter;
        this.recyclerView = recyclerView;
        this.nextPageUrl = nextPageUrl;
    }

    public void handle() {
        if (pokemonsAdapter == null)
            throw new RuntimeException("The Adapter is not set :D");

        if (recyclerView == null)
            throw new RuntimeException("The recyclerView is not set :D");

        recyclerView.setAdapter(pokemonsAdapter);
        recyclerView.addOnScrollListener(new LoadMoreListener());
    }

    private void getNextPage() {
        isDataLoading = true;
        requestNextPage();
    }

    private void requestNextPage() {
        offset += 20;
        RequestClass.getAllPokemons(new PokemonNetwork<PokemonData>() {
            @Override
            public void onResponse(PokemonData response) {
                isDataLoading = false;
                nextPageUrl = response.getNext();
                listSize = pokemonsAdapter.getData().size();
                pokemonsAdapter.addNewData(response);

                if (hasNextPage(response))
                    recyclerView.scrollToPosition(listSize - 1);
                else
                    pokemonsAdapter.removeFooter();
            }

            @Override
            public void onFailure(String exp) {
                isDataLoading = false;
                pokemonsAdapter.removeFooter();
            }
        }, offset + "", limit + "");

    }


    private boolean hasNextPage(PokemonData response) {
        return response != null && response.getNext() != null && !response.getNext().equals("");
    }

    class LoadMoreListener extends RecyclerView.OnScrollListener {
        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);

            if (nextPageUrl == null || nextPageUrl.equals("")) {
                pokemonsAdapter.removeFooter();
                return;
            }

            int visibleItemCount = recyclerView.getLayoutManager().getChildCount();
            int totalItemCount = recyclerView.getLayoutManager().getItemCount();
            int firstVisibleItemPosition = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition();
            if (!isDataLoading)
                if (visitEndOfTheLis(visibleItemCount, totalItemCount, firstVisibleItemPosition))
                    getNextPage();
        }

        private boolean visitEndOfTheLis(int visibleItemCount, int totalItemCount, int firstVisibleItemPosition) {
            return (visibleItemCount + firstVisibleItemPosition) >= totalItemCount && firstVisibleItemPosition >= 0;
        }
    }
}
