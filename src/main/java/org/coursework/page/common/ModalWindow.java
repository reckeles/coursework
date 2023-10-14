package org.coursework.page.common;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class ModalWindow {
    protected SelenideElement submitButton = Selenide.$("div.form-actions button");
    protected SelenideElement cancelButton = Selenide.$("div.form-actions a");
}
