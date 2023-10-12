package org.coursework.ui;

import org.coursework.api.ProjectProcedures;
import org.coursework.api.UserProcedures;
import org.coursework.base.BaseGUITest;
import org.coursework.model.project.Project;
import org.coursework.model.project.ProjectId;
import org.coursework.model.user.User;
import org.coursework.page.BoardPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class CreateTaskTest extends BaseGUITest {

    BoardPage boardPage = new BoardPage();
    Integer projectId;


    @BeforeMethod
    public void before(){
        Random rand = new Random();
        int int_random = rand.nextInt(1000);
        Project project = new Project("project"+int_random);
        projectId = ProjectProcedures.createProject(project);

        User user = new User("newuser"+int_random, "password_123", "Yuliia", "yuliia@gmail.com", "user");
        Integer userId = UserProcedures.createUser(user);
        setWebDriver();
        login();
    }

    @Test
    public void createTask(){
        boardPage.openPage(projectId);
        boardPage.openAddTaskFormFromBacklog();
//        createProjectPage.createProjectOnlyRequiredFields("project133");
//        projectPage.assertPageUrlIsRight();
//        projectId = projectPage.getProjectId();
    }

    @AfterMethod
    public void after() {
        ProjectProcedures.removeProject(new ProjectId(projectId));
        closeWebDriver();
    }
}
