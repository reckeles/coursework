package org.coursework.page;

import com.codeborne.selenide.SelenideElement;
import org.coursework.config.EnvConfig;
import static com.codeborne.selenide.Selenide.*;

public class BoardPage {

    private SelenideElement addTaskIconBacklogColumn = $x("//th[@data-column-id='101']//i");
    public void openPage(int projectId){
      open(EnvConfig.getBaseURL()+"/board"+projectId);
    }

    public void openAddTaskFormFromBacklog(){
        addTaskIconBacklogColumn.click();
    }
}
