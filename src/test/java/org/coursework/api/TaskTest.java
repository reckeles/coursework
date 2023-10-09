package org.coursework.api;

import org.coursework.model.project.Project;
import org.coursework.model.task.Task;
import org.coursework.model.task.TaskExtended;
import org.coursework.model.task.TaskId;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

import static org.coursework.utils.FieldsHelper.getTaskTitleField;

public class TaskTest {
    Integer projectId;
    @BeforeMethod
    public void before(){
        Random rand = new Random();
        int int_random = rand.nextInt(1000);
        Project project = new Project("project"+int_random, null, 1, null, null, null);

        projectId = ProjectProcedures.createProject(project);
        ProjectProcedures.itemIsCreated(projectId);
    }

    @Test
    public void taskFlow(){
        Random rand = new Random();
        int int_random = rand.nextInt(1000);
        Task task =  new Task("task"+int_random, projectId);

        Integer taskId = TaskProcedures.createTask(task);
        TaskProcedures.itemIsCreated(taskId);

        TaskId taskIdRequestBody = new TaskId(taskId);
        TaskExtended taskInfo = TaskProcedures.getTask(taskIdRequestBody);

        TaskProcedures.assertItemField(task.getTitle(), taskInfo.getTitle(), getTaskTitleField());

        boolean isTaskRemoved = TaskProcedures.removeTask(taskIdRequestBody);
        TaskProcedures.itemRemovingRequestIsSuccessful(isTaskRemoved);

        //TO DO - add assert on 403 error for request?????? is it good approach?????
    }
}
