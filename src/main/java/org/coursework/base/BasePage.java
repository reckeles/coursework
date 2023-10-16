package org.coursework.base;

import com.codeborne.selenide.SelenideElement;
import org.coursework.utils.Wait;
import org.openqa.selenium.WebDriver;
import org.coursework.Session;

import java.time.Instant;

abstract public class BasePage {
    protected WebDriver wd() {
        return Session.get().webdriver();
    }

    public boolean isPageLoaded(int timeoutSec) {
        Boolean customConfirm = this.customConfirm();
        if (customConfirm != null)
            return customConfirm;

        boolean result = false;

        long timeout = Instant.now().getEpochSecond() + timeoutSec;
        while (timeout > Instant.now().getEpochSecond()) {
            result = this.readyElement().exists();
            if (result)
                break;
            Wait.sleep(500);
        }

        return result;
    }

    public void confirmPageIsLoaded() {
        if (!this.isPageLoaded(5))
            throw new RuntimeException("Could not confirm that page is loaded: " + this.getClass().getSimpleName());
    }

    protected Boolean customConfirm() {
        return null;
    }

    protected void sleep(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    abstract protected SelenideElement readyElement();
    abstract public void openPage();
//    abstract protected <T> T openPage(Integer id);

}
