package org.coursework.api;

import io.qameta.allure.Step;
import org.coursework.model.Authorization;
import org.coursework.model.project.Project;
import org.coursework.model.project.ProjectExtended;
import org.coursework.model.project.ProjectId;

import static org.coursework.api.APIUtil.*;
import static org.coursework.model.KanboardMethods.*;

public class ProjectProcedures extends Procedures {
    @Step
    public static ProjectExtended getProjectById(Integer id, Authorization authorization) {
        return sendGetRequest(GET_PROJECT_BY_ID, new ProjectId(id), ProjectExtended.class, authorization);
    }

    @Step
    public static Project createProject(Project project, Authorization authorization) {
        Integer id = sendCreateRequest(CREATE_PROJECT, project, authorization);
        project.setId(id);
        return project;
    }

    @Step
    public static Boolean removeProjectById(Integer id, Authorization authorization) {
        return sendRemoveRequest(REMOVE_PROJECT, new ProjectId(id), authorization);
    }
}
