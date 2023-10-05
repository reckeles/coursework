package org.coursework.base;

import com.codeborne.selenide.WebDriverRunner;
import org.coursework.config.EnvConfig;
import org.coursework.Session;
import org.coursework.page.DashboardPage;
import org.coursework.page.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BaseGUITest {
    protected void setWebDriver(){
        Session.get().webdriver().get(String.format("http://%s:%s", EnvConfig.HTTP_BASE_URL.value, EnvConfig.HTTP_BASE_PORT.value));
        WebDriverRunner.setWebDriver(this.wd());
    }

    protected void closeWebDriver(){
        Session.get().close();
    }

    protected void login(){
        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = new DashboardPage();
        loginPage.login("admin", "admin");
        dashboardPage.searchVisible();
    }

    protected WebDriver wd() {
        return Session.get().webdriver();
    }
}
