package ru.ftc.android.shifttemple.features.users.domain;

import java.util.List;

import ru.ftc.android.shifttemple.features.books.domain.model.Success;
import ru.ftc.android.shifttemple.features.users.data.UsersRepository;

import ru.ftc.android.shifttemple.features.users.domain.model.User;

import ru.ftc.android.shifttemple.network.Carry;

public final class UsersInteractorImpl implements UsersInteractor {

    private final UsersRepository repository;

    public UsersInteractorImpl(UsersRepository repository) {
        this.repository = repository;
    }


    @Override
    public void loadUser(String id, Carry<User> carry) {
        repository.loadUser(id, carry);
    }

    @Override
    public void loginUser(String login, String password, Carry<User> carry) {
        repository.loginUser(login, password, carry);
    }

    @Override
    public void createUser(String login, String password, User user, Carry<User> carry) {
        repository.createUser(login, password, user, carry);
    }

    @Override
    public void checkUserToken(String token, Carry<Success> carry) {
        repository.checkUserToken(token, carry);
    }
}
