package com.ghamari.vahab.pokemon.main.view.pokemons;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.ghamari.vahab.pokemon.R;
import com.ghamari.vahab.pokemon.main.Utility.CustomTextView;
import com.ghamari.vahab.pokemon.main.Utility.Utility;
import com.ghamari.vahab.pokemon.main.model.Pokemon;
import com.ghamari.vahab.pokemon.main.model.PokemonData;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by VahabGh on 5/28/2019.
 */
public class PokemonsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int FOOTER_ITEM = 1;
    private static final int NORMAL_ITEM = 0;
    private List<Object> pokemons;
    private OnItemClickListener onItemClickListener;

    PokemonsAdapter(List<Pokemon> pokemons, OnItemClickListener onItemClickListener) {
        this.pokemons = (new ArrayList<Object>(pokemons));
        if (!hasFooter())
            this.pokemons.add(new FooterItem());
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == FOOTER_ITEM)
            return new FooterViewHolder(parent);


        if (viewType == NORMAL_ITEM) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.pokemon_item, parent, false);
            return new PokemonViewHolder(itemView);
        }

        throw new RuntimeException("there is no match type");
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (pokemons.get(position) instanceof Pokemon && holder instanceof PokemonViewHolder) {
            Pokemon pokemon = ((Pokemon) pokemons.get(position));
            ((PokemonViewHolder) holder).name.setText(pokemon.getName());
            ((PokemonViewHolder) holder).bind(pokemon, onItemClickListener);
        }
    }

    @Override
    public int getItemCount() {
        return pokemons.size();
    }

    private boolean hasFooter() {
        if (pokemons == null) return false;
        int listSize = pokemons.size();
        if (listSize < 1) return false;
        Object lastItem = pokemons.get(listSize - 1);
        return lastItem instanceof FooterItem;
    }

    public void removeFooter() {
        if (pokemons == null || pokemons.size() < 1) return;
        int footerPosition = pokemons.size() - 1;
        Object o = pokemons.get(footerPosition);
        if (o instanceof FooterItem) {
            pokemons.remove(footerPosition);
            notifyItemRemoved(footerPosition);
        }
    }

    public Collection getData() {
        return pokemons;
    }

    public void addNewData(PokemonData pokemonData) {
        if (pokemonData == null) return;
        if (pokemonData.getPokemonList() == null) return;

        if (pokemons == null)
            pokemons = new ArrayList<>();

        int index = pokemons.size();
        int range = pokemonData.getPokemonList().size();
        if (index > 0)
            pokemons.addAll(index - 1, pokemonData.getPokemonList());
        notifyItemRangeInserted(index, range);
    }

    @Override
    public int getItemViewType(int position) {
        Object o = pokemons.get(position);
        if (o instanceof FooterItem) {
            return FOOTER_ITEM;
        } else
            return NORMAL_ITEM;
    }

    private View makeProgressBar(Context context) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, Utility.convertDipToPixels(relativeLayout.getContext(),40));
        relativeLayout.setLayoutParams(layoutParams);
        ProgressBar pbLoading = new ProgressBar(context);
        RelativeLayout.LayoutParams llProgress = new RelativeLayout.LayoutParams(
                Utility.convertDipToPixels(relativeLayout.getContext(),40),
                Utility.convertDipToPixels(relativeLayout.getContext(),40));
        llProgress.addRule(RelativeLayout.CENTER_IN_PARENT);
        pbLoading.setLayoutParams(llProgress);
        relativeLayout.addView(pbLoading);
        return relativeLayout;
    }

    public interface OnItemClickListener {
        void onItemClick(Pokemon item);
    }

    public class PokemonViewHolder extends RecyclerView.ViewHolder {
        public CustomTextView name;

        PokemonViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.name);
        }

        void bind(final Pokemon item, final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(item);
                }
            });
        }
    }

    protected class FooterViewHolder extends RecyclerView.ViewHolder {
        FooterViewHolder(View itemView) {
            super(makeProgressBar(itemView.getContext()));
        }
    }

    private class FooterItem {

    }
}

