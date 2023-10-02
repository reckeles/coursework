package org.coursework.base;

import com.codeborne.selenide.WebDriverRunner;
import org.coursework.Session;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.coursework.Config;

public class BaseGUITest {
    @BeforeMethod
    public void before() {
        Session.get().webdriver().get(String.format("http://%s:%s", Config.HTTP_BASE_URL.value, Config.HTTP_BASE_PORT.value));
        WebDriverRunner.setWebDriver(this.wd());
    }

    @AfterMethod
    public void after() {
        Session.get().close();
    }

    protected WebDriver wd() {
        return Session.get().webdriver();
    }
}
