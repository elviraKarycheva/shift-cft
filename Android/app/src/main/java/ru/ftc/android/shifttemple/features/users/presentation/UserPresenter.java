package ru.ftc.android.shifttemple.features.users.presentation;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import ru.ftc.android.shifttemple.features.MvpPresenter;
import ru.ftc.android.shifttemple.features.users.domain.UsersInteractor;
import ru.ftc.android.shifttemple.features.users.domain.model.User;


final class UserPresenter extends MvpPresenter<UserView> {
    private final UsersInteractor interactor;

    UserPresenter(UsersInteractor interactor) {
        this.interactor = interactor;
    }

    @Override
    protected void onViewReady() {
        loadusers();
    }

    private void loadusers() {
        /*view.showProgress();
        interactor.loadusers(new Carry<List<user>>() {

            @Override
            public void onSuccess(List<user> result) {
                view.showuserList(result);
                view.hideProgress();
            }

            @Override
            public void onFailure(Throwable throwable) {
                view.hideProgress();
                view.showError(throwable.getMessage());
            }

        });
        */
    }

    void onuserSelected(User user) {
        view.showProgress();
       /* interactor.loaduser(user.getId(), new Carry<user>() {

            @Override
            public void onSuccess(user result) {
                view.hideProgress();
                // do something
                view.showError(result.getStatus());
            }

            @Override
            public void onFailure(Throwable throwable) {
                view.hideProgress();
                view.showError(throwable.getMessage());
            }

        });
        */
    }

    void onuserLongClicked(User user) {
        view.showError("May be added to favorite.. May be no;)"); // TODO: favorite
        /*view.showProgress();
        interactor.deleteuser(user.getId(), new Carry<Success>() {

            @Override
            public void onSuccess(Success result) {
                loadusers();
            }

            @Override
            public void onFailure(Throwable throwable) {
                view.hideProgress();
                view.showError(throwable.getMessage());
            }
        });
        */
    }

    private final AtomicInteger atomicInteger = new AtomicInteger();

    public void onCreateuserClicked() {
        int id = atomicInteger.incrementAndGet();
        String name = "Name_" + id;
        String author = "Kolsha_" + id;
        int pages = 7 * id;

        /*user user = new user(name, author, String.valueOf(pages));
        interactor.createuser(user, new Carry<user>() {
            @Override
            public void onSuccess(user result) {
                loadusers();
            }

            @Override
            public void onFailure(Throwable throwable) {
                view.showError(throwable.getMessage());
            }
        });
        */
    }
}


