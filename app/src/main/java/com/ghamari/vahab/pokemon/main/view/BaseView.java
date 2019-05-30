package com.ghamari.vahab.pokemon.main.view;

/**
 * Created by VahabGh on 5/28/2019.
 */
public interface BaseView<T> {
    void showProgress();
    void hideProgress();
    T createPresenter();
}
