package com.ghamari.vahab.pokemon.main.view.pokemons;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ghamari.vahab.pokemon.R;
import com.ghamari.vahab.pokemon.main.model.Pokemon;
import com.ghamari.vahab.pokemon.main.presenter.PokemonsPresenter;
import com.ghamari.vahab.pokemon.main.view.MainActivity;
import com.ghamari.vahab.pokemon.main.view.pokemondetail.PokemonDetailFragment;
import com.ghamari.vahab.pokemon.main.view.pokemondetail.RecyclerPaginateHandler;

import java.util.List;

/**
 * Created by VahabGh on 5/28/2019.
 */
public class PokemonsFragment extends Fragment implements PokemonsView<PokemonsPresenter> {

    private RecyclerView recyclerView;
    private PokemonsAdapter pokomonsAdapter;
    private PokemonsPresenter presenter;
    private View view;
    private PokemonsViewModel viewModel;

    public PokemonsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_pokemons, container, false);
        presenter = createPresenter();
        setTitle();
        initViews(view);
        presenter.getAllPokemons();
        return view;
    }

    private void setTitle() {
        if (getActivity() != null)
            getActivity().setTitle("Pokemons");
    }

    @Override
    public PokemonsPresenter createPresenter() {
        viewModel = ViewModelProviders.of(this).get(PokemonsViewModel.class);
        viewModel.pokemonsPresenter.setView(this);
        return viewModel.pokemonsPresenter;
    }

    private void initViews(View view) {
        recyclerView = view.findViewById(R.id.rv_pokemons);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(recyclerView.getContext(), RecyclerView.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);
        recyclerView.setLayoutManager(mLayoutManager);
    }


    @Override
    public void showProgress() {
    }

    @Override
    public void hideProgress() {
    }

    @Override
    public void success(String nextPage, List<Pokemon> pokemons) {
        setAdapter(nextPage, pokemons);
    }

    @Override
    public void failed(String data) {

    }

    public void setAdapter(String nextPage, List<Pokemon> pokemons) {
        pokomonsAdapter = new PokemonsAdapter(pokemons, new RecItemClickListener());
        new RecyclerPaginateHandler(pokomonsAdapter, recyclerView, nextPage).handle();
    }

    private void openDetailFragment(String url) {
        if (getActivity() == null) return;
        Bundle bundle = new Bundle();
        bundle.putString("POKEMON_URL", url);
        PokemonDetailFragment pokemonDetailFragment = new PokemonDetailFragment();
        pokemonDetailFragment.setArguments(bundle);
        ((MainActivity) getActivity()).setFragment(pokemonDetailFragment, true);
    }

    class RecItemClickListener implements PokemonsAdapter.OnItemClickListener {
        @Override
        public void onItemClick(Pokemon item) {
            if (item == null) return;
            openDetailFragment(item.getUrl());
        }
    }
}

