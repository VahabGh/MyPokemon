package com.ghamari.vahab.pokemon.main.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.ghamari.vahab.pokemon.R;
import com.ghamari.vahab.pokemon.main.Utility.Utility;

public class SplashActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        if (Utility.isNetworkAvailable(this))
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    goToMainActivity();
                }
            }, 2500);
        else
            Toast.makeText(this, "There is No network Connection,Try Again Plz", Toast.LENGTH_LONG).show();
    }

    private void goToMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
