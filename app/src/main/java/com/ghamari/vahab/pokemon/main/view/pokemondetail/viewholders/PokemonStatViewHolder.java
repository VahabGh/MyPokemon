package com.ghamari.vahab.pokemon.main.view.pokemondetail.viewholders;

import android.view.View;

import com.ghamari.vahab.pokemon.R;
import com.ghamari.vahab.pokemon.main.Utility.CustomTextView;
import com.ghamari.vahab.pokemon.main.model.StatInfo;
import com.ghamari.vahab.pokemon.main.model.pokemondetail.PokemonDetailItem;
import com.ghamari.vahab.pokemon.main.view.pokemondetail.PokemonDetailItemViewHolder;

/**
 * Created by VahabGh on 5/29/2019.
 */
public class PokemonStatViewHolder extends PokemonDetailItemViewHolder {

    private CustomTextView tvStat;
    private CustomTextView tvBaseStat;

    public PokemonStatViewHolder(View itemView) {
        super(itemView);
        tvStat = ((CustomTextView) itemView.findViewById(R.id.tv_stat));
        tvBaseStat = ((CustomTextView) itemView.findViewById(R.id.tv_base_stat));
    }

    @Override
    public void bind(PokemonDetailItem pokemonDetailItem) {
       if (pokemonDetailItem == null) return;
       if (!(pokemonDetailItem instanceof StatInfo)) return;

        StatInfo item = ((StatInfo) pokemonDetailItem);
       tvStat.setText(item.getStat().getName());
       tvBaseStat.setText(item.getBaseStat());
    }
}
