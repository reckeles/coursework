package org.coursework.page.logged_in;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.coursework.config.EnvConfig;
import org.coursework.page.common.LoggedInFilterPage;
import org.coursework.page.logged_in.modal_windows.task.CloseTaskModalWindow;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.*;
import static org.coursework.config.TextConfig.TASK_STATUS_CLOSED_LABEL;

public class TaskPage extends LoggedInFilterPage {
    private Integer taskId;
    private SelenideElement taskSummaryBox = $("section#task-summary");

    private SelenideElement closeTaskAction = $x("//a[contains(@href, 'close')]");

    private SelenideElement statusLabel = $x("//div[@class='task-summary-column'][1]//li[1]/span");

    @Step
    public CloseTaskModalWindow openCloseTaskModalWindow(){
        closeTaskAction.click();
        return page(CloseTaskModalWindow.class);
    }

    @Step
    public void assertTaskIsClosed(){
        sleep(3);
        Assert.assertEquals(statusLabel.getText(), TASK_STATUS_CLOSED_LABEL.value);
    }



    @Override
    protected SelenideElement readyElement() {
        return taskSummaryBox;
    }

    @Step
    @Override
    public void openPage() {
        open(EnvConfig.getBaseURL()+"/task/"+taskId);
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }
}
