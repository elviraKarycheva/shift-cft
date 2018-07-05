package ru.ftc.android.shifttemple.features.users.presentation;


import android.content.Context;

import ru.ftc.android.shifttemple.features.MvpView;

public interface UserView extends MvpView {
    void showProgress();

    void hideProgress();

    void showError(String message);



    void setData(String login, String password);

    // TODO: datasource
    Context getContext();

    void hideActivity();
}
