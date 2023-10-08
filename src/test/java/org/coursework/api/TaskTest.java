package org.coursework.api;

import org.coursework.model.project.Project;
import org.coursework.model.task.Task;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

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

    }
}
