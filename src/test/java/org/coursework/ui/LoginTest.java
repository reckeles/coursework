package org.coursework.ui;

import org.coursework.base.BaseGUITest;
import org.coursework.page.DashboardPage;
import org.coursework.page.LoginPage;
import org.testng.annotations.Test;


public class LoginTest extends BaseGUITest {
    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();

    @Test
    public void loginValidUser() {
        loginPage.login("admin", "admin");
        dashboardPage.searchVisible();
    }

    @Test
    public void loginEmptyUsernameField() {
        loginPage.loginWithoutPassword("admin");
        loginPage.usernameIsRequired();
    }

    @Test
    public void loginEmptyPasswordField() {
        loginPage.loginWithoutUsername("admin");
        loginPage.passwordIsRequired();
    }

    @Test
    public void loginInvalidUser() {
        loginPage.login("admin1", "admin");
        loginPage.assertBadCredsAlertIsPresent();
    }
}
