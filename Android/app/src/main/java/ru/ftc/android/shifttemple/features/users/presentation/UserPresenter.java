package ru.ftc.android.shifttemple.features.users.presentation;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import ru.ftc.android.shifttemple.features.MvpPresenter;
import ru.ftc.android.shifttemple.features.users.domain.UsersInteractor;
import ru.ftc.android.shifttemple.features.users.domain.model.User;
import ru.ftc.android.shifttemple.network.Carry;


final class UserPresenter extends MvpPresenter<UserView> {
    //TODO: ask ..
    public String loginText;
    public String passwordText;
    private final UsersInteractor interactor;

    UserPresenter(UsersInteractor interactor) {
        this.interactor = interactor;
    }

    //TODO: ask ..
    @Override
    protected void onViewReady() {
        view.hideProgress();
        view.setData(loginText, passwordText);
    }

    public void onLoginButtonClicked() {
        if (loginText.isEmpty() || passwordText.isEmpty()) {
            view.showError("Fill all fields");
            return;
        }
        view.showProgress();
        interactor.loginUser(loginText, passwordText, new Carry<User>() {

            @Override
            public void onSuccess(User result) {
                // view hide etc
                view.hideProgress();
            }

            @Override
            public void onFailure(Throwable throwable) {
                view.hideProgress();
                view.showError(throwable.getMessage());
            }

        });
    }
}


