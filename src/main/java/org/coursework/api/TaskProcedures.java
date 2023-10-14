package org.coursework.api;

import io.qameta.allure.Step;
import org.coursework.model.Authorization;
import org.coursework.model.task.Task;
import org.coursework.model.task.TaskExtended;
import org.coursework.model.task.TaskId;

import static org.coursework.api.APIUtil.*;
import static org.coursework.model.KanboardMethods.*;

public class TaskProcedures extends Procedures {

    @Step
    public static TaskExtended getTaskById(Integer id, Authorization authorization) {
        return sendGetRequest(GET_TASK, new TaskId(id), TaskExtended.class, authorization);
    }

    @Step
    public static Task createTask(Task task, Authorization authorization) {
        Integer id = sendCreateRequest(CREATE_TASK, task, authorization);
        task.setId(id);
        return task;
    }

    @Step
    public static Boolean removeTaskById(Integer id, Authorization authorization) {

        return sendRemoveRequest(REMOVE_TASK, new TaskId(id), authorization);
    }
}
