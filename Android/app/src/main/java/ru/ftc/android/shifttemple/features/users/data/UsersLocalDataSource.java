package ru.ftc.android.shifttemple.features.users.data;

public interface UsersLocalDataSource {

    String getString(final String key);

    void putString(final String key, final String value);

}
