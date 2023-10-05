package org.coursework.page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.coursework.config.TextConfig;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.attribute;

public class LoginPage {
    private SelenideElement usernameInput = Selenide.$("input#form-username");
    private SelenideElement passwordInput = Selenide.$("input#form-password");
    private SelenideElement submitButton = Selenide.$x("//button[@type='submit']");

    private SelenideElement badCredentialsAlert = Selenide.$("p.alert.alert-error");

    @Step("Attempt of login")
    public void login(String name, String password) {
        usernameInput.sendKeys(name);
        passwordInput.sendKeys(password);
        submitButton.click();
    }

    @Step
    public void loginWithoutPassword(String name) {
        usernameInput.sendKeys(name);
        submitButton.click();
    }

    @Step
    public void loginWithoutUsername(String password) {
        passwordInput.sendKeys(password);
        submitButton.click();
    }

    @Step
    public void usernameIsRequired() {
        usernameInput.shouldHave(attribute("required"));
    }

    @Step
    public void passwordIsRequired() {
        passwordInput.shouldHave(attribute("required"));
    }

    @Step
    public void assertBadCredsAlertIsPresent() {
        Assert.assertEquals(badCredentialsAlert.getText(), TextConfig.LOGIN_PAGE_BAD_CREDS_ALERT.value);
    }
}
