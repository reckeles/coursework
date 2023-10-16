package org.coursework.page.logged_in;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.coursework.config.EnvConfig;
import org.coursework.page.common.LoggedInFilterPage;
import org.coursework.page.logged_in.modal_windows.task.AddCommentToTaskModalWindow;
import org.coursework.page.logged_in.modal_windows.task.CloseTaskModalWindow;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.coursework.config.TextConfig.TASK_STATUS_CLOSED_LABEL;

public class TaskPage extends LoggedInFilterPage {
    private Integer taskId;
    SoftAssert softAssert = new SoftAssert();
    private SelenideElement taskSummaryBox = $("section#task-summary");

    private SelenideElement commentsDetails = $x("//details[@class='accordion-section'][6]");

    private SelenideElement closeTaskAction = $x("//a[contains(@href, 'close')]");
    private SelenideElement addCommentAction = $x("//a[contains(@href, '/comment/create')]");


    private SelenideElement statusLabel = $x("//div[@class='task-summary-column'][1]//li[1]/span");

    private SelenideElement comment = $(".comment");
    private ElementsCollection listOfCommentsTexts = $$(".comment-content div p");
    private ElementsCollection listOfCommentsCreators = $$("strong.comment-username");

    private SelenideElement textAreaCommentForm = $x("//textarea[@name='comment']");
    private SelenideElement submitButtonCommentForm = $x("//button[@type='submit']");

    @Step
    public CloseTaskModalWindow openCloseTaskModalWindow() {
        closeTaskAction.click();
        return page(CloseTaskModalWindow.class);
    }

    @Step
    public AddCommentToTaskModalWindow openAddCommentModalWindow() {
        addCommentAction.click();
        return page(AddCommentToTaskModalWindow.class);
    }

    @Step
    public void assertTaskIsClosed() {
        sleep(3);
        Assert.assertEquals(statusLabel.getText(), TASK_STATUS_CLOSED_LABEL.value);
    }

    @Step
    public void assertCommentTextIsSameAsExpected(String expectedText) {
        comment.shouldBe(visible);
        SelenideElement lastCommentText = listOfCommentsTexts.get(listOfCommentsTexts.size() - 1);
        softAssert.assertEquals(lastCommentText.getText(), expectedText);
    }

    @Step
    public void assertCommentCreatorIsSameAsExpected(String expectedUsername) {
        comment.shouldBe(visible);
        SelenideElement lastCommentCreator = listOfCommentsCreators.get(listOfCommentsCreators.size() - 1);
        softAssert.assertEquals(lastCommentCreator.getText(), expectedUsername);
    }

    @Step
    public void addComment(String comment){
        commentsDetails.click();
        textAreaCommentForm.sendKeys(comment);
        submitButtonCommentForm.click();
    }

    @Override
    protected SelenideElement readyElement() {
        return taskSummaryBox;
    }

    @Step
    @Override
    public void openPage() {
        open(EnvConfig.getBaseURL() + "/task/" + taskId);
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }
}
