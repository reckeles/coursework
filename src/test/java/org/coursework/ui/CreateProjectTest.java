package org.coursework.ui;

import org.coursework.api.ProjectProcedures;
import org.coursework.base.BaseGUITest;
import org.coursework.model.project.ProjectId;
import org.coursework.page.CreateProjectPage;
import org.coursework.page.DashboardPage;
import org.coursework.page.ProjectPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateProjectTest extends BaseGUITest {
    private DashboardPage dashboardPage = new DashboardPage();
    private CreateProjectPage createProjectPage = new CreateProjectPage();
    private ProjectPage projectPage = new ProjectPage();
    private int projectId;

    @BeforeMethod(alwaysRun = true)
    public void before(){
        setWebDriver();
        login("admin", "admin");
    }

    @Test(groups = { "smoke", "regression", "CRUD_project" })
    public void createProject(){
        dashboardPage.openCreateProjectWindow();
        createProjectPage.createProjectOnlyRequiredFields("project133");
        projectPage.assertPageUrlIsRight();
        projectId = projectPage.getProjectId();
    }

    @AfterMethod(alwaysRun = true)
    public void after() {
        closeWebDriver();
        ProjectProcedures.removeProject(projectId);
    }
}
