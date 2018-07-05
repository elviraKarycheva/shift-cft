package ru.ftc.android.shifttemple.features.tasks.presentation;


import android.content.Context;

import java.util.List;

import ru.ftc.android.shifttemple.features.MvpView;
import ru.ftc.android.shifttemple.features.tasks.domain.model.Task;

interface TasksListView extends MvpView {

    void showProgress();

    void hideProgress();

    void showTaskList(List<Task> list);

    void showError(String message);

    void showLoginForm();

    Context getContext();

}