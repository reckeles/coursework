package org.coursework.page.logged_in.board;

import com.codeborne.selenide.SelenideElement;
import org.coursework.base.BaseBlock;

public class TaskPreviewBlock extends BaseBlock {
    private final SelenideElement baseElement;
    public final SelenideElement name;

    public TaskPreviewBlock(SelenideElement baseElement) {
        this.baseElement = baseElement;
        this.name = baseElement.$x(".//div[contains(@class, 'title')]/a");

    }

    @Override
    protected SelenideElement baseElement() {
        return this.baseElement;
    }
}
