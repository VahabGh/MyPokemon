package com.ghamari.vahab.pokemon.main.Utility;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by VahabGh on 12/29/2017.
 */
public class Utility {

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static int convertDipToPixels(Context context, float dips) {
        return (int) (dips * context.getResources().getDisplayMetrics().density + 0.5f);
    }
}
