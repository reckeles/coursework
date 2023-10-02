package org.coursework.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class Login {

    @Step(value="pung")
    public void fillInUsername(){
        $("input#form-username").sendKeys("admin");
    }

    @Step
    public void fillInPassword(){
        $("input#form-password").sendKeys("admin");
    }

    @Step
    public void clickButton(){
        $x("//button[@type='submit']").click();
    }


}
