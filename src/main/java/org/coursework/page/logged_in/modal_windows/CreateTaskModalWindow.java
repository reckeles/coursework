package org.coursework.page.logged_in.modal_windows;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.coursework.page.common.ModalWindow;
import org.coursework.page.logged_in.BoardPage;

import static com.codeborne.selenide.Selenide.page;

public class CreateTaskModalWindow extends ModalWindow {
    private SelenideElement titleInput = Selenide.$("input#form-title");

    public BoardPage createTaskOnlyRequiredFields(String title){
        titleInput.sendKeys(title);
        submitButton.click();
        return page(BoardPage.class);
    }
    public void createTaskAllFields(){}

}
