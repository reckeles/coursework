package org.coursework.api;

import org.coursework.base.BaseAPITest;
import org.coursework.model.project.Project;
import org.coursework.model.task.Task;
import org.coursework.model.task.TaskExtended;
import org.coursework.model.user.User;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.coursework.api.ProjectProcedures.*;
import static org.coursework.api.TaskProcedures.*;
import static org.coursework.api.UserProcedures.*;
import static org.coursework.utils.FieldsHelper.getTaskTitleField;
import static org.coursework.utils.TestData.*;

public class TaskTest extends BaseAPITest {
    Project project;
    User user;

    @BeforeMethod(alwaysRun = true)
    public void before() {
        user = createUser(generateDefaultUserData(), admin);
        project = createProject(generateProjectWithOwnerData(user.getId()), user);
    }

    @Test(groups = {"CRUD_task_API", "API", "smoke", "regression"})
    public void taskFlow() {
        Task task = createTask(generateDefaultTaskData(project.getId()), user);

        TaskExtended taskInfo = getTaskById(task.getId(), user);
        assertItemField(task.getTitle(), taskInfo.getTitle(), getTaskTitleField());

        boolean isTaskRemoved = removeTaskById(task.getId(), user);
        itemRemovingRequestIsSuccessful(isTaskRemoved);
    }

    @AfterMethod(alwaysRun = true)
    public void after() {
        removeProjectById(project.getId(), user);
        removeUserById(user.getId(), admin);
    }
}
