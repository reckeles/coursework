package org.coursework.page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;

public class DashboardPage {
    private SelenideElement search = Selenide.$("input#form-search");

    @Step("User is logged in successfully")
    public void searchVisible() {
        search.shouldBe(visible);
    }
}
