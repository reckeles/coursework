package org.coursework.page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

public class DashboardPage {
    private SelenideElement search = Selenide.$("input#form-search");
    private SelenideElement newProjectButton = Selenide.$("//section//a[@href='/project/create']");

    @Step("User is logged in successfully")
    public void searchVisible() {
        search.shouldBe(visible);
    }

    @Step
    public void openCreateProjectWindow(){
        newProjectButton.click();
    }
}
