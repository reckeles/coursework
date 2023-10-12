package org.coursework.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.coursework.Session;
import org.coursework.config.EnvConfig;
import org.testng.Assert;

public class ProjectPage {
    private final String PROJECT_URL_REGEX = String.format("%s/project/\\d+", EnvConfig.getBaseURL());
    private SelenideElement projectIsOpenLabel = Selenide.$x("//ul[@class='panel']/li[1]");
    @Step
    public void assertPageUrlIsRight(){
        //TO DO switch for waiting of page loading
        projectIsOpenLabel.shouldBe(Condition.visible);
        String url = WebDriverRunner.url();
        Assert.assertTrue(url.matches(PROJECT_URL_REGEX));
    }

    public int getProjectId(){
        String url = WebDriverRunner.url();
        String[] splitURL = url.split("/");
        return Integer.parseInt(splitURL[splitURL.length-1]);
    }
}