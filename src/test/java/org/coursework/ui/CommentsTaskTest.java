package org.coursework.ui;

import org.coursework.base.BaseGUITest;
import org.coursework.page.logged_in.TaskPage;
import org.coursework.page.logged_in.modal_windows.task.AddCommentToTaskModalWindow;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.coursework.model.project.Project;
import org.coursework.model.task.Task;
import org.coursework.model.user.User;

import static org.coursework.api.ProjectProcedures.createProject;
import static org.coursework.api.ProjectProcedures.removeProjectById;
import static org.coursework.api.TaskProcedures.createTask;
import static org.coursework.api.UserProcedures.createUser;
import static org.coursework.api.UserProcedures.removeUserById;
import static org.coursework.utils.TestData.*;

public class CommentsTaskTest extends BaseGUITest {
    User user;
    Project project;
    Task task;

    @BeforeMethod(alwaysRun = true)
    public void before() {
        user = createUser(generateDefaultUserData(), admin);
        project = createProject(generateProjectWithOwnerData(user.getId()), user);
        task = createTask(generateDefaultTaskData(project.getId()), user);

        setWebDriver();
        login(user.getUsername(), user.getPassword());
    }

    @Test(groups = {"CRUD_task_UI", "UI", "smoke", "regression"})
    public void addCommentViaModalWindow(){
        TaskPage taskPage = new TaskPage();
        taskPage.setTaskId(task.getId());
        taskPage.openPage();
        AddCommentToTaskModalWindow addCommentToTaskModalWindow = taskPage.openAddCommentModalWindow();

        String comment = getRandomStr();
        taskPage = addCommentToTaskModalWindow.addCommentWithoutEmail(comment);

        taskPage.assertCommentCreatorIsSameAsExpected(user.getUsername());
        taskPage.assertCommentTextIsSameAsExpected(comment);
        //TODO add assertion for dates in comment
    }

    @Test(groups = {"CRUD_task_UI", "UI", "regression"})
    public void addCommentViaFormOnTaskPage(){
        TaskPage taskPage = new TaskPage();
        taskPage.setTaskId(task.getId());
        taskPage.openPage();

        String comment = getRandomStr();
        taskPage.addComment(comment);

        taskPage.assertCommentCreatorIsSameAsExpected(user.getUsername());
        taskPage.assertCommentTextIsSameAsExpected(comment);
        //TODO add assertion for dates in comment
    }

    @AfterMethod(alwaysRun = true)
    public void after() {
        closeWebDriver();

        removeProjectById(project.getId(), user);
        project = null;
        removeUserById(user.getId(), admin);
        user = null;
    }


}
