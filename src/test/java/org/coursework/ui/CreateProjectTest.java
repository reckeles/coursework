package org.coursework.ui;

import org.coursework.base.BaseGUITest;
import org.coursework.page.CreateProjectPage;
import org.coursework.page.DashboardPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateProjectTest extends BaseGUITest {
    private DashboardPage dashboardPage = new DashboardPage();
    private CreateProjectPage projectPage = new CreateProjectPage();

    @BeforeMethod
    public void before(){
        setWebDriver();
        login();
    }

    @Test
    public void createProject(){
        dashboardPage.openCreateProjectWindow();
    }



    @AfterMethod
    public void after() {
        closeWebDriver();
    }
}
