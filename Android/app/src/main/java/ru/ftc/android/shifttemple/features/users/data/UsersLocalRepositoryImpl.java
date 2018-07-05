package ru.ftc.android.shifttemple.features.users.data;

public final class UsersLocalRepositoryImpl implements UsersLocalRepository {
    private final UsersLocalDataSource dataSource;

    public UsersLocalRepositoryImpl(UsersLocalDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public String getUserToken() {
        return dataSource.getString("token");
    }

    @Override
    public void setUserToken(String token) {
        dataSource.putString("token", token);
    }
}
