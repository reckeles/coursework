package org.coursework.ui;

import org.coursework.base.BaseGUITest;
import org.coursework.model.user.User;
import org.coursework.page.DashboardPage;
import org.coursework.page.LoginPage;
import org.testng.annotations.*;

import static org.coursework.api.UserProcedures.createUser;
import static org.coursework.api.UserProcedures.removeUserById;
import static org.coursework.utils.TestData.generateDefaultUserData;
import static org.coursework.utils.TestData.getRandomStr;


public class LoginTest extends BaseGUITest {
    private LoginPage loginPage = new LoginPage();
    private DashboardPage dashboardPage = new DashboardPage();
    private User user;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        user = createUser(generateDefaultUserData(), admin);
        setWebDriver();
    }

    @Test(groups = {"authflow", "UI", "smoke", "regression"})
    public void loginValidUser() {
        loginPage.login(user.getUsername(), user.getPassword());
        dashboardPage.searchVisible();
    }

    @Test(groups = {"authflow", "UI", "regression"})
    public void loginEmptyUsernameField() {
        loginPage.loginWithoutPassword(user.getUsername());
        loginPage.usernameIsRequired();
    }

    @Test(groups = {"authflow", "UI", "regression"})
    public void loginEmptyPasswordField() {
        loginPage.loginWithoutUsername(user.getPassword());
        loginPage.passwordIsRequired();
    }

    @Test(groups = {"authflow", "UI", "smoke", "regression"})
    public void loginWithInvalidPassword() {
        loginPage.login(user.getUsername(), getRandomStr());
        loginPage.assertBadCredsAlertIsPresent();
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        closeWebDriver();
        removeUserById(user.getId(), admin);
        user = null;
    }
}
