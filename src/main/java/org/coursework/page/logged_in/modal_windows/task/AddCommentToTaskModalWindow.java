package org.coursework.page.logged_in.modal_windows.task;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.coursework.page.common.ModalWindow;
import org.coursework.page.logged_in.TaskPage;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class AddCommentToTaskModalWindow extends ModalWindow {
    private SelenideElement textComment = $x("//div[@id='modal-content']//textarea[@name='comment']");

    @Step
    public TaskPage addCommentWithoutEmail(String comment) {
        textComment.sendKeys(comment);
        submitButton.click();
        return page(TaskPage.class);
    }

    @Step
    public TaskPage addCommentWithEmail(String comment) {
        return page(TaskPage.class);
    }

}
