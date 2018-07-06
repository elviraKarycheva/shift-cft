package ru.ftc.android.shifttemple.features.tasks.presentation;

import java.util.List;

import ru.ftc.android.shifttemple.exception.NotAuthorizedException;
import ru.ftc.android.shifttemple.features.MvpPresenter;
import ru.ftc.android.shifttemple.features.tasks.domain.TasksInteractor;
import ru.ftc.android.shifttemple.features.tasks.domain.model.Bid;
import ru.ftc.android.shifttemple.features.tasks.domain.model.Task;
import ru.ftc.android.shifttemple.network.Carry;

final class TaskPresenter extends MvpPresenter<TaskView> {
    private final TasksInteractor interactor;

    private String task_id;

    private Boolean taskIsMine = false;

    TaskPresenter(TasksInteractor interactor) {
        this.interactor = interactor;
    }

    @Override
    protected void onViewReady() {
        loadTask();
        view.showError("Task id: " + task_id);
    }

    private void loadTaskBids() {
        interactor.loadTaskBids(task_id, new Carry<List<Bid>>() {

            @Override
            public void onSuccess(List<Bid> result) {
                view.showBidList(result);
                view.hideProgress();
            }

            @Override
            public void onFailure(Throwable throwable) {
                view.hideProgress();
                view.showError(throwable.getMessage());
                if (throwable.getClass() == NotAuthorizedException.class) {
                    view.showLoginForm();
                }

            }

        });
    }

    //TODO: Ask it's norm?
    private void checkTask(Task task) {
        interactor.checkTaskIsMine(task, new Carry<Boolean>() {
            @Override
            public void onSuccess(Boolean result) {
                taskIsMine = result;
                if (!result) {
                    //showAnswerForm
                    //hideDeleteButton
                    //etc
                }
            }

            @Override
            public void onFailure(Throwable throwable) {
            }
        });
    }

    private void loadTask() {
        view.showProgress();
        interactor.loadTask(task_id, new Carry<Task>() {
            @Override
            public void onSuccess(Task result) {
                view.showTask(result);
                loadTaskBids();
            }

            @Override
            public void onFailure(Throwable throwable) {
                view.hideProgress();
                view.showError(throwable.getMessage());
                if (throwable.getClass() == NotAuthorizedException.class) {
                    view.showLoginForm();
                }
            }
        });

    }

    void onRefreshTask() {
        loadTask();

    }

    void onBidSelected(Bid bid) {
        view.showError("You choose bid from: " + bid.getUserName());
        //interactor.selectTaskBid
    }


    void onBidLongClicked(Bid bid) {
        //view.showError("May be added to favorite.. May be no;)"); // TODO: favorite
    }

    void setTaskId(final String task_id) {
        this.task_id = task_id;
    }


}