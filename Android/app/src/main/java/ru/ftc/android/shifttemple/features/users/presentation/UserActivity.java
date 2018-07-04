package ru.ftc.android.shifttemple.features.users.presentation;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import ru.ftc.android.shifttemple.R;
import ru.ftc.android.shifttemple.features.BaseActivity;
import ru.ftc.android.shifttemple.features.MvpPresenter;
import ru.ftc.android.shifttemple.features.MvpView;


public final class UserActivity extends BaseActivity implements UserView {

    private ProgressBar progressBar;
    //private RecyclerView recyclerView;
    //private Button createuserButton;


    private UserPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        initView();
    }

    private void initView() {
        progressBar = findViewById(R.id.login_progress);
        /*recyclerView = findViewById(R.id.users_recycle_view);
        reateuserButton = findViewById(R.id.create_button);

        createuserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onCreateuserClicked();
            }
        });

        adapter = new usersAdapter(this, new usersAdapter.SelectuserListener() {
            @Override
            public void onuserSelect(user user) {
                presenter.onuserSelected(user);
            }

            @Override
            public void onuserLongClick(user user) {
                presenter.onuserLongClicked(user);
            }
        });

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        */
    }

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
}
