package org.coursework.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.coursework.Session;
import org.coursework.config.EnvConfig;
import org.testng.Assert;

public class ProjectPage {
    private SelenideElement projectIsOpenLabel = Selenide.$x("//ul[@class='panel']/li[1]");
    @Step
    public void assertPageUrlIsRight(){
        projectIsOpenLabel.shouldBe(Condition.visible);
        //TO DO - GET project ID by name from API request
        int id = 5;
        String expectedURL = String.format("http://%s/project/%s", EnvConfig.HTTP_BASE_URL.value, id);
        Assert.assertEquals(Session.get().webdriver().getCurrentUrl(), expectedURL);

    }
}
