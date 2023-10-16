package org.coursework.ui;

import org.coursework.api.ProjectProcedures;
import org.coursework.base.BaseGUITest;
import org.coursework.model.user.User;
import org.coursework.page.logged_in.modal_windows.CreateProjectModalWindow;
import org.coursework.page.logged_in.DashboardPage;
import org.coursework.page.logged_in.ProjectPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.coursework.api.ProjectProcedures.removeProjectById;
import static org.coursework.api.UserProcedures.createUser;
import static org.coursework.api.UserProcedures.removeUserById;
import static org.coursework.utils.TestData.generateDefaultUserData;
import static org.coursework.utils.TestData.getRandomStr;

public class CreateProjectTest extends BaseGUITest {
    private DashboardPage dashboardPage;
    private CreateProjectModalWindow createProjectModalWindow;
    private ProjectPage projectPage;
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
        dashboardPage = new DashboardPage();
        dashboardPage.openPage();
        createProjectModalWindow = dashboardPage.openCreateProjectWindow();
        projectPage = createProjectModalWindow.createProjectOnlyRequiredFields(getRandomStr());
        projectPage.confirmPageIsLoaded();
        projectPage.assertPageUrlIsRight();
        projectId = projectPage.getProjectId();
    }

    @AfterMethod(alwaysRun = true)
    public void after() {
        closeWebDriver();

        removeProjectById(projectId, user);

        removeUserById(user.getId(), admin);
        user = null;
    }
}
