package org.coursework.api;

import io.qameta.allure.Step;
import org.coursework.model.project.Project;
import org.coursework.model.project.ProjectExtended;
import org.coursework.model.project.ProjectId;
import org.coursework.model.task.Task;
import org.coursework.model.task.TaskExtended;
import org.coursework.model.task.TaskId;

import static org.coursework.api.APIUtil.*;
import static org.coursework.model.KanboardMethods.*;

public class TaskProcedures extends Procedures {

    @Step
    public static TaskExtended getTask(TaskId taskId) {
        return sendGetRequest(GET_TASK, taskId, TaskExtended.class);
    }

    @Step
    public static Integer createTask(Task task) {
        return sendCreateRequest(CREATE_TASK, task);
    }

    @Step
    public static Boolean removeTask(TaskId taskId) {
        return sendRemoveRequest(REMOVE_TASK, taskId);
    }
}
