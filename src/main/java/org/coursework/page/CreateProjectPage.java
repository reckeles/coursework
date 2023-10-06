package org.coursework.page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

public class CreateProjectPage {

    private SelenideElement nameInput = Selenide.$("input#form-name");
    private SelenideElement idInput = Selenide.$("input#form-identifier");
    private SelenideElement perSwimlaneTaskLimitsCheckbox = Selenide.$x("//input[@name='per_swimlane_task_limits']");
    private SelenideElement taskLimitInput = Selenide.$("input#form-task_limit");
    private SelenideElement submitButton = Selenide.$x("//form[@id='project-creation-form']//button");
    private SelenideElement cancelButton = Selenide.$x("//form[@id='project-creation-form']//a");

    @Step
    public void createProjectOnlyRequiredFields(String name){
        nameInput.sendKeys(name);
        submitButton.click();
    }

    @Step
    public void createProjectAllFields(String name, String id, int taskLimit){
        nameInput.sendKeys(name);
        idInput.sendKeys(id);
        perSwimlaneTaskLimitsCheckbox.click();
        taskLimitInput.sendKeys(String.valueOf(taskLimit));
        submitButton.click();
    }


}
