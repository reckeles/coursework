package org.coursework.ui;

import org.coursework.api.ProjectProcedures;
import org.coursework.base.BaseGUITest;
import org.coursework.model.user.User;
import org.coursework.page.CreateProjectPage;
import org.coursework.page.DashboardPage;
import org.coursework.page.ProjectPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.coursework.api.UserProcedures.createUser;
import static org.coursework.utils.TestData.generateDefaultUserData;
import static org.coursework.utils.TestData.getRandomStr;

public class CreateProjectTest extends BaseGUITest {
    private DashboardPage dashboardPage = new DashboardPage();
    private CreateProjectPage createProjectPage = new CreateProjectPage();
    private ProjectPage projectPage = new ProjectPage();
    private int projectId;
    User user;

    @BeforeMethod(alwaysRun = true)
    public void before() {
        user = createUser(generateDefaultUserData(), admin);

        setWebDriver();
        login(user.getUsername(), user.getPassword());
    }

    @Test(groups = {"CRUD_project_UI", "UI", "smoke", "regression"})
    public void createProject() {
        dashboardPage.openCreateProjectWindow();
        createProjectPage.createProjectOnlyRequiredFields(getRandomStr());
        projectPage.assertPageUrlIsRight();
        projectId = projectPage.getProjectId();
    }

    @AfterMethod(alwaysRun = true)
    public void after() {
        closeWebDriver();
        ProjectProcedures.removeProjectById(projectId, user);
    }
}
