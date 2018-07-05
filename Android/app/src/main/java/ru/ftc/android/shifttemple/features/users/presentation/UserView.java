package ru.ftc.android.shifttemple.features.users.presentation;


import android.content.Context;

import ru.ftc.android.shifttemple.features.MvpView;

public interface UserView extends MvpView {
    void showProgress();

    void hideProgress();

    void showError(String message);


    //TODO: ask ..
    void setData(String login, String password);

    Context getContext();
}
