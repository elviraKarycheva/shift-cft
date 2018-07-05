package ru.ftc.android.shifttemple.features.tasks.domain;

import java.util.List;

import ru.ftc.android.shifttemple.features.books.domain.model.Success;
import ru.ftc.android.shifttemple.features.tasks.data.TasksRepository;
import ru.ftc.android.shifttemple.features.tasks.domain.model.Bid;
import ru.ftc.android.shifttemple.features.tasks.domain.model.Task;
import ru.ftc.android.shifttemple.network.Carry;

public final class TasksInteractorImpl implements TasksInteractor {

    private final TasksRepository repository;

    public TasksInteractorImpl(TasksRepository repository) {
        this.repository = repository;
    }

    @Override
    public void loadTasks(Carry<List<Task>> carry) {
        repository.loadTasks(carry);
    }

    @Override
    public void loadTask(String id, Carry<Task> carry) {
        repository.loadTask(id, carry);
    }

    @Override
    public void createTask(Task task, Carry<Task> carry) {
        repository.createTask(task, carry);
    }

    @Override
    public void deleteTask(String id, Carry<Success> carry) {
        repository.deleteTask(id, carry);
    }

    @Override
    public void createTaskBid(String id, Bid bid, Carry<Bid> carry) {
        repository.createTaskBid(id, bid, carry);
    }

    @Override
    public void loadTaskBids(String id, Carry<List<Bid>> carry) {
        repository.loadTaskBids(id, carry);
    }
}
