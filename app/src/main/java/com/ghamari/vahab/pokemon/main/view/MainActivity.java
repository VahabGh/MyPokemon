package com.ghamari.vahab.pokemon.main.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.ghamari.vahab.pokemon.R;
import com.ghamari.vahab.pokemon.main.view.pokemons.PokemonsFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null)
            setFragment(new PokemonsFragment(), true);
    }

    @Override
    public void onBackPressed() {
        FragmentManager fm = getSupportFragmentManager();
        if (fm.getBackStackEntryCount() > 1)
            fm.popBackStack();
        else
            System.exit(0);
    }

    public void setFragment(Fragment fragment, boolean addToBackStack) {
        try {
            if (addToBackStack)
                getSupportFragmentManager().beginTransaction()
//                        .setCustomAnimations(R.anim.slide_from_right, R.anim.slide_to_left, R.anim.slide_from_left, R.anim.slide_to_right)
                        .add(R.id.my_fragment, fragment, " ")
                        .addToBackStack(null).commit();
            else
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.my_fragment, fragment, " ")
//                        .setCustomAnimations(R.anim.slide_from_left, R.anim.slide_to_right)
                        .commit();


        } catch (Exception exp) {

        }
    }
}
