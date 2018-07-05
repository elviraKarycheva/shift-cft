package ru.ftc.android.shifttemple.features.tasks.presentation;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import ru.ftc.android.shifttemple.App;
import ru.ftc.android.shifttemple.R;
import ru.ftc.android.shifttemple.features.MvpPresenter;
import ru.ftc.android.shifttemple.features.books.domain.model.Success;
import ru.ftc.android.shifttemple.features.tasks.domain.TasksInteractor;
import ru.ftc.android.shifttemple.features.tasks.domain.model.Task;
import ru.ftc.android.shifttemple.network.Carry;

final class TasksListPresenter extends MvpPresenter<TasksListView> {
    private final TasksInteractor interactor;

    TasksListPresenter(TasksInteractor interactor) {
        this.interactor = interactor;
    }

    @Override
    protected void onViewReady() {

        // TODO: move this to presenter
        Context context = view.getContext();

        SharedPreferences sharedPrefs = context.getSharedPreferences(context.getString(R.string.user_settings_key),
                Context.MODE_PRIVATE);

        String token = sharedPrefs.getString(context.getString(R.string.query_token_name), "");
        if (token.isEmpty()) {
            view.showLoginForm();
        } else {
            loadTasks();
        }
    }

    private void loadTasks() {
        view.showProgress();
        interactor.loadTasks(new Carry<List<Task>>() {

            @Override
            public void onSuccess(List<Task> result) {
                view.showTaskList(result);
                view.hideProgress();
            }

            @Override
            public void onFailure(Throwable throwable) {
                view.hideProgress();
                view.showError(throwable.getMessage());
            }

        });
    }

    void onRefreshTasks() {
        loadTasks();

    }

    void onTaskSelected(Task task) {
        view.showProgress();
        interactor.loadTask(task.getId(), new Carry<Task>() {

            @Override
            public void onSuccess(Task result) {
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
    }

    void onTaskLongClicked(Task task) {
        view.showError("May be added to favorite.. May be no;)"); // TODO: favorite


        /*view.showProgress();
        interactor.deleteTask(Task.getId(), new Carry<Success>() {

            @Override
            public void onSuccess(Success result) {
                loadTasks();
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

    public void onCreateTaskClicked() {
        int id = atomicInteger.incrementAndGet();
        String name = "Name_" + id;
        String author = "Kolsha_" + id;
        int pages = 7 * id;

        Task Task = new Task(name, author, String.valueOf(pages));
        interactor.createTask(Task, new Carry<Task>() {
            @Override
            public void onSuccess(Task result) {
                loadTasks();
            }

            @Override
            public void onFailure(Throwable throwable) {
                view.showError(throwable.getMessage());
            }
        });
    }
}
