package com.ghamari.vahab.pokemon.main.view.pokemondetail;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.ghamari.vahab.pokemon.main.model.pokemondetail.PokemonDetailItem;

/**
 * Created by VahabGh on 5/29/2019.
 */
public abstract class PokemonDetailItemViewHolder extends RecyclerView.ViewHolder {

    public PokemonDetailItemViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void bind(PokemonDetailItem pokemonDetailItem);
}
