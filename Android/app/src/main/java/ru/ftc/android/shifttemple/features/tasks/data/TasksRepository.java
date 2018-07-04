package ru.ftc.android.shifttemple.features.tasks.data;


import java.util.List;

import ru.ftc.android.shifttemple.features.books.domain.model.Success;
import ru.ftc.android.shifttemple.features.tasks.domain.model.Task;
import ru.ftc.android.shifttemple.network.Carry;

public interface TasksRepository {

    void loadTasks(Carry<List<Task>> carry);

    void loadTask(String id, Carry<Task> carry);

    void createTask(Task task, Carry<Task> carry);

    void deleteTask(String id, Carry<Success> carry);
}