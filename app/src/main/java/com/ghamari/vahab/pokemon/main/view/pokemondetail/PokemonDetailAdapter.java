package com.ghamari.vahab.pokemon.main.view.pokemondetail;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ghamari.vahab.pokemon.R;
import com.ghamari.vahab.pokemon.main.model.pokemondetail.PokemonDetailItem;
import com.ghamari.vahab.pokemon.main.model.pokemondetail.PokemonDetailItemType;
import com.ghamari.vahab.pokemon.main.view.pokemondetail.viewholders.HeaderViewHolder;
import com.ghamari.vahab.pokemon.main.view.pokemondetail.viewholders.PokemonAbilityViewHolder;
import com.ghamari.vahab.pokemon.main.view.pokemondetail.viewholders.PokemonInfoViewHolder;
import com.ghamari.vahab.pokemon.main.view.pokemondetail.viewholders.PokemonStatViewHolder;

import java.util.List;

/**
 * Created by VahabGh on 5/29/2019.
 */
public class PokemonDetailAdapter extends RecyclerView.Adapter<PokemonDetailItemViewHolder> {

    private List<PokemonDetailItem> pokemonDetailItems;

    public PokemonDetailAdapter(List<PokemonDetailItem> pokemonDetailItems) {
        this.pokemonDetailItems = pokemonDetailItems;
    }

    @Override
    public PokemonDetailItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView;

        if (viewType == PokemonDetailItemType.INFO_HEADER.id()) {
            itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.info_header, parent, false);
            return new HeaderViewHolder(itemView);
        }

        if (viewType == PokemonDetailItemType.STAT_HEADER.id()) {
            itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.stat_header_item, parent, false);
            return new HeaderViewHolder(itemView);
        }

        if (viewType == PokemonDetailItemType.ABILITY_HEADER.id()) {
            itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.ability_header_item, parent, false);
            return new HeaderViewHolder(itemView);
        }

        if (viewType == PokemonDetailItemType.POKEMON_ABILITY.id()) {
            itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.ability_item, parent, false);
            return new PokemonAbilityViewHolder(itemView);
        }

        if (viewType == PokemonDetailItemType.POKEMON_STAT.id()) {
            itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.stat_item, parent, false);
            return new PokemonStatViewHolder(itemView);
        }

        if (viewType == PokemonDetailItemType.POKEMON_INFO.id()) {
            itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.info_item, parent, false);
            return new PokemonInfoViewHolder(itemView);
        }

        throw new RuntimeException("there is no match item");
    }

    @Override
    public void onBindViewHolder(PokemonDetailItemViewHolder pokemonDetailItemViewHolder, int i) {
        PokemonDetailItem pokemonDetailItem = pokemonDetailItems.get(i);
        pokemonDetailItemViewHolder.bind(pokemonDetailItem);
    }

    @Override
    public int getItemCount() {
        return pokemonDetailItems.size();
    }

    @Override
    public int getItemViewType(int position) {
        return pokemonDetailItems.get(position).getType().id();
    }
}
