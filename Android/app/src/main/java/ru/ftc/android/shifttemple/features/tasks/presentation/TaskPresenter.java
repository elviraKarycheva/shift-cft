package ru.ftc.android.shifttemple.features.tasks.presentation;

import ru.ftc.android.shifttemple.features.MvpPresenter;
import ru.ftc.android.shifttemple.features.tasks.domain.TasksInteractor;
import ru.ftc.android.shifttemple.features.tasks.domain.model.Bid;

final class TaskPresenter extends MvpPresenter<TaskView> {
    private final TasksInteractor interactor;

    TaskPresenter(TasksInteractor interactor) {
        this.interactor = interactor;
    }

    @Override
    protected void onViewReady() {
        //loadTasks();
    }

    private void loadTasks() {
        /*view.showProgress();
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
                if(throwable.getClass() == NotAuthorizedException.class){
                    view.showLoginForm();
                }

            }

        });*/
    }

    void onRefreshTasks() {
        //loadTasks();

    }

    void onTaskSelected(Bid bid) {
        /*view.showProgress();
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
        */
    }

    void onTaskLongClicked(Bid bid) {
        //view.showError("May be added to favorite.. May be no;)"); // TODO: favorite
    }


}
