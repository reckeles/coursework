package org.coursework.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.coursework.Session;
import org.coursework.config.EnvConfig;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.*;

public class BoardPage {

    private SelenideElement addTaskIconBacklog = $x("//th[contains(@class, 'board-column-header')][1]//i[contains(@class, 'js-modal-large')]");
    private ElementsCollection listOfTasksNamesInBacklog = $$x("//td[1]//div[contains(@data-task-url, 'task')]//div[@class='task-board-title']/a");
    public void openPage(int projectId){
      open(EnvConfig.getBaseURL()+"/board/"+projectId);
//      refresh();
    }

    public void openAddTaskFormFromBacklog(){
        addTaskIconBacklog.click();
    }

    public void assertThatTaskNameIsSameAsAddedTask(String expectedName){
        SelenideElement lastTaskName = listOfTasksNamesInBacklog.get(listOfTasksNamesInBacklog.size());
        Assert.assertEquals(lastTaskName.getText(), expectedName);
    }
}
