package org.coursework;

import io.qameta.allure.Step;
import org.coursework.base.BaseGUITest;
import org.coursework.pages.Login;
import org.openqa.selenium.bidi.log.Log;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.URI;
import java.net.URISyntaxException;

import static com.codeborne.selenide.Selenide.*;

public class FirstTest extends BaseGUITest {
    @Test
    public void firsttest() {
        Login loginPage = new Login();
        loginPage.fillInUsername();
        loginPage.fillInPassword();
        loginPage.clickButton();
        trydjs();
//        $("input#form-username").sendKeys("admin");
//        $("input#form-password").sendKeys("admin");
//        $x("//button[@type='submit']").click();


        Assert.assertEquals($(".alert").getText(), "There is nothing assigned to you.");
    }

    @Step
    public void trydjs(){
        System.out.println("dsjkf");
    }
}
