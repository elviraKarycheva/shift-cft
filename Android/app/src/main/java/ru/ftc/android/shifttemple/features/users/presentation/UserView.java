package ru.ftc.android.shifttemple.features.users.presentation;


import ru.ftc.android.shifttemple.features.MvpView;

public interface UserView extends MvpView {
    void showProgress();

    void hideProgress();

    void showError(String message);
}
