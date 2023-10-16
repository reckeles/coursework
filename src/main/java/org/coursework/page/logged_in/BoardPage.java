package org.coursework.page.logged_in;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.coursework.config.EnvConfig;
import org.coursework.page.common.LoggedInFilterPage;
import org.coursework.page.logged_in.modal_windows.CreateTaskModalWindow;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.*;

public class BoardPage extends LoggedInFilterPage {
    private Integer projectId;

    private SelenideElement addTaskIconBacklog = $x("//th[contains(@class, 'board-column-header')][1]//i[contains(@class, 'js-modal-large')]");
    private ElementsCollection listOfTasksNamesInBacklog = $$x("//td[1]//div[contains(@data-task-url, 'task')]//div[@class='task-board-title']/a");

    public CreateTaskModalWindow openAddTaskFormFromBacklog(){
        addTaskIconBacklog.click();
        return page(CreateTaskModalWindow.class);
    }

    //TODO refactor as done in example ProductItemPreviewBlock (kind of don't need to copy everything
    public void assertThatTaskNameIsSameAsAddedTask(String expectedName){
        SelenideElement lastTaskName = listOfTasksNamesInBacklog.get(listOfTasksNamesInBacklog.size());
        Assert.assertEquals(lastTaskName.getText(), expectedName);
    }

    @Override
    protected SelenideElement readyElement() {
        return addTaskIconBacklog;
    }

    @Override
    public void openPage() {
        open(EnvConfig.getBaseURL()+"/board/"+projectId);
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }
}
