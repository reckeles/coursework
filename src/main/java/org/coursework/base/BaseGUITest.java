package org.coursework.base;

import com.codeborne.selenide.WebDriverRunner;
import org.coursework.config.EnvConfig;
import org.coursework.Session;
import org.coursework.api.model.user.User;
import org.coursework.page.logged_in.DashboardPage;
import org.coursework.page.auth.LoginPage;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.page;
import static org.coursework.config.EnvConfig.ADMIN_PASSWORD;
import static org.coursework.config.EnvConfig.ADMIN_USERNAME;

public class BaseGUITest {
    protected final User admin = new User(ADMIN_USERNAME.value, ADMIN_PASSWORD.value);

    protected void setWebDriver() {
        Session.get().webdriver().get(EnvConfig.getBaseURL());
        WebDriverRunner.setWebDriver(this.wd());
    }

    protected void closeWebDriver() {
        Session.get().close();
    }

    protected DashboardPage login(String username, String password) {
        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = new DashboardPage();
        loginPage.login(username, password);
        dashboardPage.searchVisible();
        return page(DashboardPage.class);
    }

    protected WebDriver wd() {
        return Session.get().webdriver();
    }
}
