package ru.ftc.android.shifttemple.features.users.data;

import android.content.Context;
import android.content.SharedPreferences;

import ru.ftc.android.shifttemple.R;

public final class UsersLocalDataSourceImpl implements UsersLocalDataSource {

    private SharedPreferences sharedPreferences;

    public UsersLocalDataSourceImpl(Context context) {
        sharedPreferences = context.getSharedPreferences(context.getString(R.string.user_settings_key),
                Context.MODE_PRIVATE);
    }

    @Override
    public String getString(String key) {
        return sharedPreferences.getString(key, "");
    }

    @Override
    public void putString(String key, String value) {
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();

        prefsEditor.putString(key, value);
        prefsEditor.apply();
    }
}
