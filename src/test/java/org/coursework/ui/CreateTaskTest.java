package org.coursework.ui;

import org.coursework.base.BaseGUITest;
import org.coursework.model.project.Project;
import org.coursework.model.user.User;
import org.coursework.page.logged_in.BoardPage;
import org.coursework.page.logged_in.modal_windows.CreateTaskModalWindow;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.coursework.api.ProjectProcedures.createProject;
import static org.coursework.api.ProjectProcedures.removeProjectById;
import static org.coursework.api.UserProcedures.createUser;
import static org.coursework.api.UserProcedures.removeUserById;
import static org.coursework.utils.TestData.*;

public class CreateTaskTest extends BaseGUITest {
    private User user;
    private Project project;


    @BeforeMethod(alwaysRun = true)
    public void before() {
        user = createUser(generateDefaultUserData(), admin);
        project = createProject(generateProjectWithOwnerData(user.getId()), user);

        setWebDriver();
        login(user.getUsername(), user.getPassword());
    }

    @Test(groups = {"CRUD_task_UI", "UI", "smoke", "regression"})
    public void createTask() {
        BoardPage boardPage = new BoardPage();
        boardPage.setProjectId(project.getId());
        boardPage.openPage();
        String taskName = getRandomStr();
        CreateTaskModalWindow createTaskModalWindow = boardPage.openAddTaskFormFromBacklog();
        boardPage = createTaskModalWindow.createTaskOnlyRequiredFields(taskName);
        boardPage.assertThatTaskNameIsSameAsAddedTask(taskName);
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

