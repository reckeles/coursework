package org.coursework.ui;

import com.codeborne.selenide.WebDriverRunner;
import org.coursework.Session;
import org.coursework.base.BaseGUITest;
import org.coursework.config.EnvConfig;
import org.coursework.page.DashboardPage;
import org.coursework.page.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTest extends BaseGUITest {
    private LoginPage loginPage = new LoginPage();
    private DashboardPage dashboardPage = new DashboardPage();
    @BeforeMethod(alwaysRun = true)
    public void before() {
        System.out.println("Login before");
        setWebDriver();
    }

    @Test(groups = { "smoke", "regression", "authflow" })
    public void loginValidUser() {
        loginPage.login("admin", "admin");
        dashboardPage.searchVisible();
    }

    @Test(groups = { "regression", "authflow" })
    public void loginEmptyUsernameField() {
        loginPage.loginWithoutPassword("admin");
        loginPage.usernameIsRequired();
    }

    @Test(groups = { "regression", "authflow" })
    public void loginEmptyPasswordField() {
        loginPage.loginWithoutUsername("admin");
        loginPage.passwordIsRequired();
    }

    @Test(groups = { "smoke", "regression", "authflow" })
    public void loginInvalidUser() {
        loginPage.login("admin1", "admin");
        loginPage.assertBadCredsAlertIsPresent();
    }

    @AfterMethod(alwaysRun = true)
    public void after() {
        closeWebDriver();
    }
}
