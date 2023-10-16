package org.coursework.page.logged_in;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.coursework.config.EnvConfig;
import org.coursework.page.common.LoggedInFilterPage;
import org.coursework.page.logged_in.modal_windows.task.AddCommentToTaskModalWindow;
import org.coursework.page.logged_in.modal_windows.task.CloseTaskModalWindow;
import org.coursework.utils.Wait;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.coursework.config.TextConfig.TASK_STATUS_CLOSED_LABEL;

public class TaskPage extends LoggedInFilterPage {
    private Integer taskId;

    private SelenideElement taskSummaryBox = $("section#task-summary");

    private SelenideElement commentsDetails = $x("//details[@class='accordion-section'][6]");

    private SelenideElement closeTaskAction = $x("//a[contains(@href, 'close')]");
    private SelenideElement addCommentAction = $x("//a[contains(@href, '/comment/create')]");


    private SelenideElement statusLabel = $x("//div[@class='task-summary-column'][1]//li[1]/span");

    private SelenideElement comment = $(".comment");
    //TODO baseelemnt
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
    public void addComment(String comment) {
        commentsDetails.click();
        textAreaCommentForm.sendKeys(comment);
        submitButtonCommentForm.click();
    }

    @Step
    public void assertTaskIsClosed() {
        Wait.sleep(3 * 1000);
        Assert.assertEquals(statusLabel.getText(), TASK_STATUS_CLOSED_LABEL.value, "Task status is not closed.");
    }

    @Step
    public void assertCommentTextIsSameAsExpected(String expectedCommentText) {
        comment.shouldBe(visible);

        SelenideElement lastCommentText = listOfCommentsTexts.get(listOfCommentsTexts.size() - 1);
        Assert.assertEquals(lastCommentText.getText(), expectedCommentText, "Comment's text is not same as expected.");
    }

    @Step
    public void assertCommentCreatorIsSameAsExpected(String expectedUsername) {
        comment.shouldBe(visible);
        SelenideElement lastCommentCreator = listOfCommentsCreators.get(listOfCommentsCreators.size() - 1);
        Assert.assertEquals(lastCommentCreator.getText(), expectedUsername, "Comment's creator name is not same as expected.");
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
