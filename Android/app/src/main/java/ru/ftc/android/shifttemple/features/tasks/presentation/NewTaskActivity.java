package ru.ftc.android.shifttemple.features.tasks.presentation;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.v4.widget.SwipeRefreshLayout;
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
import ru.ftc.android.shifttemple.features.tasks.domain.model.Bid;
import ru.ftc.android.shifttemple.features.tasks.domain.model.Task;
import ru.ftc.android.shifttemple.features.users.presentation.UserLoginLoginActivity;

public final class NewTaskActivity extends BaseActivity implements NewTaskView {


    private NewTaskPresenter presenter;

    private ProgressBar progressBar;
    private EditText inputTitle;
    private EditText inputDescription;
    private Button createButton;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_task_activity);
        initView();
    }


    private void initView() {

        progressBar = findViewById(R.id.new_task_progress);

        createButton = findViewById(R.id.new_task_create_button);

        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onCreateButtonClicked();
            }
        });

        inputTitle = findViewById(R.id.new_task_input_title);
        inputDescription = findViewById(R.id.new_task_input_description);


        inputTitle.addTextChangedListener(titleWatcher);
        inputDescription.addTextChangedListener(descriptiondWatcher);


    }


    private final TextWatcher titleWatcher = new TextWatcher() {
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        public void afterTextChanged(Editable s) {
            presenter.onTitleTextChanged(s.toString());
        }
    };

    private final TextWatcher descriptiondWatcher = new TextWatcher() {
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        public void afterTextChanged(Editable s) {
            presenter.onDescriptionTextChanged(s.toString());
        }
    };

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }



    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    protected MvpPresenter<NewTaskView> getPresenter() {
        presenter = PresenterFactory.createNewTaskPresenter(this);
        return presenter;
    }

    @Override
    protected MvpView getMvpView() {
        return this;
    }

    @Override
    public void hideActivity() {
        finish();
    }
}
