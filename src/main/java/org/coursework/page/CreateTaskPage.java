package org.coursework.page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class CreateTaskPage {
    private SelenideElement titleInput = Selenide.$("input#form-title");
    private SelenideElement submitButton = Selenide.$x("//button[@type='submit']");

    public void createTaskOnlyRequiredFields(String title){
        titleInput.sendKeys(title);
        submitButton.click();
    }
    public void createTaskAllFields(){}

}
