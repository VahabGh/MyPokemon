package com.ghamari.vahab.pokemon.main.view.pokemondetail.viewholders;

import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.ghamari.vahab.pokemon.R;
import com.ghamari.vahab.pokemon.main.Utility.CustomTextView;
import com.ghamari.vahab.pokemon.main.model.pokemondetail.PokemonDetailItem;
import com.ghamari.vahab.pokemon.main.model.pokemondetail.PokemonInfo;
import com.ghamari.vahab.pokemon.main.view.pokemondetail.PokemonDetailItemViewHolder;

/**
 * Created by VahabGh on 5/29/2019.
 */
public class PokemonInfoViewHolder extends PokemonDetailItemViewHolder {

    private CustomTextView tvName;
    private CustomTextView tvHeight;
    private CustomTextView tvWeight;
    private CustomTextView tvBaseExp;
    private ImageView ivPokemon;

    public PokemonInfoViewHolder(View itemView) {
        super(itemView);

        tvName = itemView.findViewById(R.id.tv_name);
        tvHeight = itemView.findViewById(R.id.tv_height);
        tvWeight = itemView.findViewById(R.id.tv_weight);
        tvBaseExp = itemView.findViewById(R.id.tv_base_exp);
        ivPokemon = itemView.findViewById(R.id.iv_pokemon);
    }

    @Override
    public void bind(PokemonDetailItem pokemonDetailItem) {
        if (pokemonDetailItem == null) return;
        if (!(pokemonDetailItem instanceof PokemonInfo)) return;

        PokemonInfo item = ((PokemonInfo) pokemonDetailItem);

        tvName.setText(item.getName());
        tvHeight.setText("Height : "+item.getHeight());
        tvWeight.setText("Weight : "+item.getWeight());
        tvBaseExp.setText(item.getBaseExprience());
        setPokemonImage(item.getUrl());
    }

    private void setPokemonImage(String url) {
        Glide.with(itemView.getContext())
                .load(url)
                .into(ivPokemon);
    }
}
