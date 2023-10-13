package org.coursework.api;

import org.coursework.model.project.Project;
import org.coursework.model.project.ProjectExtended;
import org.coursework.model.project.ProjectId;
import org.coursework.utils.FieldsHelper;
import org.coursework.utils.ObjectPrinter;
import org.testng.annotations.Test;

import java.util.Random;

public class ProjectTest {

    @Test
    public void projectFlow(){
        Random rand = new Random();
        int int_random = rand.nextInt(1000);
        Project project = new Project("project"+int_random, null, 1, null, null, null);

        ProjectProcedures.createProject(project);
        ProjectProcedures.itemIsCreated(project.getId());

        ProjectId projectIdRequestBody = new ProjectId(project.getId());
        ObjectPrinter.print(projectIdRequestBody);
        ProjectExtended projectInfo = ProjectProcedures.getProject(projectIdRequestBody);

        ProjectProcedures.assertItemField(project.getName(), projectInfo.getName(), FieldsHelper.getProjectNameField());

        boolean isProjectRemoved = ProjectProcedures.removeProject(project.getId());
        ProjectProcedures.itemRemovingRequestIsSuccessful(isProjectRemoved);
    }
}
