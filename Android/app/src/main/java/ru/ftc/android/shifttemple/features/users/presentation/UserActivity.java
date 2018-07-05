package ru.ftc.android.shifttemple.features.users.presentation;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import ru.ftc.android.shifttemple.R;
import ru.ftc.android.shifttemple.features.BaseActivity;
import ru.ftc.android.shifttemple.features.MvpPresenter;
import ru.ftc.android.shifttemple.features.MvpView;


public final class UserActivity extends BaseActivity implements UserView {

    private ProgressBar progressBar;
    private EditText inputLogin;
    private EditText inputPassword;
    private Button loginButton;
    private Button linkRegisterButton;


    private UserPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        initView();
    }

    private void initView() {
        progressBar = findViewById(R.id.login_progress);

        loginButton = findViewById(R.id.btn_login);

        linkRegisterButton = findViewById(R.id.btn_link_reg);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onLoginButtonClicked();
            }
        });

        linkRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(TasksActivity.this, UserActivity.class);

                //startActivity(intent);
                showError("Register later");
            }
        });


        inputLogin = findViewById(R.id.login_input_login);
        inputPassword = findViewById(R.id.login_input_password);


        inputLogin.addTextChangedListener(loginWatcher);
        inputPassword.addTextChangedListener(passwordWatcher);

    }



    private final TextWatcher loginWatcher = new TextWatcher() {
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        public void afterTextChanged(Editable s) {
            presenter.loginText = s.toString();
        }
    };

    private final TextWatcher passwordWatcher = new TextWatcher() {
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        public void afterTextChanged(Editable s) {
            presenter.passwordText = s.toString();
        }
    };





    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
        //recyclerView.setVisibility(View.GONE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
        //recyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void setData(String login, String password) {
        inputLogin.setText(login);
        inputPassword.setText(password);
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    protected MvpPresenter<UserView> getPresenter() {
        presenter = PresenterFactory.createPresenter(this);
        return presenter;
    }

    @Override
    protected MvpView getMvpView() {
        return this;
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void hideActivity() {
        this.finish();
    }
}
