package org.coursework.ui;

import org.coursework.base.BaseGUITest;
import org.coursework.page.CreateProjectPage;
import org.coursework.page.DashboardPage;
import org.coursework.page.ProjectPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateProjectTest extends BaseGUITest {
    private DashboardPage dashboardPage = new DashboardPage();
    private CreateProjectPage createProjectPage = new CreateProjectPage();
    private ProjectPage projectPage = new ProjectPage();

    @BeforeMethod
    public void before(){
        setWebDriver();
        login();
    }

    @Test
    public void createProject(){
        dashboardPage.openCreateProjectWindow();
        createProjectPage.createProjectOnlyRequiredFields("project133");
        projectPage.assertPageUrlIsRight();
    }

    @AfterMethod
    public void after() {
        //TO DO - delete projects via API
        closeWebDriver();
    }
}
