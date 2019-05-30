package com.ghamari.vahab.pokemon.main.view.pokemondetail;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ghamari.vahab.pokemon.R;
import com.ghamari.vahab.pokemon.main.model.Pokemon;
import com.ghamari.vahab.pokemon.main.model.pokemondetail.PokemonDetailItem;
import com.ghamari.vahab.pokemon.main.presenter.PokemonDetailPresenter;

import java.util.List;

/**
 * Created by VahabGh on 5/28/2019.
 */
public class PokemonDetailFragment extends Fragment implements PokemonDetailView<PokemonDetailPresenter> {

    private View view;
    private PokemonDetailPresenter presenter;
    private String pokemonUrl;
    private RecyclerView recyclerView;
    private PokemonDetailAdapter pokemonDetailAdapter;
    private PokemonDetailViewModel viewModel;

    public PokemonDetailFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_pokemon_detail, container, false);
        presenter = createPresenter();
        pokemonUrl = getPokemonUrl();
        setTitle();
        initView(view);
        presenter.getPokemonDetail(pokemonUrl);
        return view;
    }

    private void initView(View view) {
        recyclerView = view.findViewById(R.id.rv_pokemons);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
    }

    private String getPokemonUrl() {
        Bundle arguments = getArguments();
        if (arguments.containsKey("POKEMON_URL"))
            return arguments.getString("POKEMON_URL");
        return "";
    }


    private void setTitle() {
        if (getActivity() != null)
            getActivity().setTitle("Pokemon Info");
    }


    @Override
    public PokemonDetailPresenter createPresenter() {
        viewModel = ViewModelProviders.of(this).get(PokemonDetailViewModel.class);
        viewModel.pokemonDetailPresenter.setView(this);
        return viewModel.pokemonDetailPresenter;
    }

    private void setAdapter(List<PokemonDetailItem> pokemonDetailItems) {
        pokemonDetailAdapter = new PokemonDetailAdapter(pokemonDetailItems);
        if (recyclerView != null)
            recyclerView.setAdapter(pokemonDetailAdapter);
    }

    @Override
    public void setPokemonDetail(Pokemon pokemon) {
        setAdapter(PokemonDataAdapter.adapt(pokemon));
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
}
