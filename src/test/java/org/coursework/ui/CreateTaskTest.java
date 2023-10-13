package org.coursework.ui;

import org.coursework.api.ProjectProcedures;
import org.coursework.api.UserProcedures;
import org.coursework.base.BaseGUITest;
import org.coursework.model.project.Project;
import org.coursework.model.project.ProjectId;
import org.coursework.model.user.User;
import org.coursework.model.user.UserId;
import org.coursework.page.BoardPage;
import org.coursework.page.CreateTaskPage;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class CreateTaskTest extends BaseGUITest {

    private BoardPage boardPage = new BoardPage();
    private CreateTaskPage createTaskPage = new CreateTaskPage();
    private int int_random;


    private User user;
    private Project project;


    @BeforeMethod(alwaysRun = true)
    public void before() {
        Random rand = new Random();
        int_random = rand.nextInt(100000);
        user = new User("newuser" + int_random, "password_123", "Yuliia", "yuliia@gmail.com", "app-admin");
        UserProcedures.createUser(user);

        project = new Project("project" + int_random, user.getId());
        ProjectProcedures.createProject(project);

        setWebDriver();
        login(user.getUsername(), user.getPassword());
    }

    @Test(groups = {"smoke", "regression", "CRUD_tasks", "single"})
    public void createTask() {
        boardPage.openPage(project.getId());
//        try {
//            Thread.sleep(60*1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        String taskName = "task " + int_random;
        boardPage.openAddTaskFormFromBacklog();
        createTaskPage.createTaskOnlyRequiredFields(taskName);
        boardPage.assertThatTaskNameIsSameAsAddedTask(taskName);
    }

    @AfterMethod(alwaysRun = true)
    public void after() {
        closeWebDriver();
        ProjectProcedures.removeProject(project.getId(), user);
        UserProcedures.removeUser(user.getId());
        user = null;
    }
}

