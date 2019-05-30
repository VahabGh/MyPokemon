package com.ghamari.vahab.pokemon.main.view.pokemondetail.viewholders;

import android.view.View;
import android.widget.ImageView;

import com.ghamari.vahab.pokemon.R;
import com.ghamari.vahab.pokemon.main.Utility.CustomTextView;
import com.ghamari.vahab.pokemon.main.model.AbilityInfo;
import com.ghamari.vahab.pokemon.main.model.pokemondetail.PokemonDetailItem;
import com.ghamari.vahab.pokemon.main.view.pokemondetail.PokemonDetailItemViewHolder;

/**
 * Created by VahabGh on 5/29/2019.
 */
public class PokemonAbilityViewHolder extends PokemonDetailItemViewHolder {

    private CustomTextView tvName;
    private CustomTextView tvSlot;
    private ImageView ivIsHidden;

    public PokemonAbilityViewHolder(View itemView) {
        super(itemView);
        tvName = ((CustomTextView) itemView.findViewById(R.id.tv_name));
        tvSlot = ((CustomTextView) itemView.findViewById(R.id.tv_slot));
        ivIsHidden = ((ImageView) itemView.findViewById(R.id.iv_isHidden));
    }

    @Override
    public void bind(PokemonDetailItem pokemonDetailItem) {
        if (pokemonDetailItem == null) return;
        if (!(pokemonDetailItem instanceof AbilityInfo)) return;

        AbilityInfo item = ((AbilityInfo) pokemonDetailItem);
        tvName.setText(item.getAbility().getName());
        tvSlot.setText(item.getSlot());
        ivIsHidden.setImageResource(item.isHidden() ? R.drawable.ok : R.drawable.nok);
    }
}
