package org.coursework.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.coursework.base.BaseAPITest;
import org.coursework.model.base.BaseRequestBody;
import org.coursework.model.base.BaseResponse;
import org.coursework.model.project.Project;
import org.coursework.model.project.ProjectExtended;
import org.coursework.model.project.ProjectId;
import org.coursework.model.user.User;
import org.coursework.model.user.UserExtended;
import org.coursework.model.user.UserId;
import org.testng.Assert;

import static org.coursework.api.APIUtil.*;
import static org.coursework.model.KanboardMethods.*;

public class ProjectProcedures extends Procedures {
    @Step
    public static ProjectExtended getProject(ProjectId projectId) {
        return sendGetRequest(GET_PROJECT_BY_ID, projectId, ProjectExtended.class);
    }

    @Step
    public static Integer createProject(Project project) {
        return sendCreateRequest(CREATE_PROJECT, project);
    }

    @Step
    public static Boolean removeProject(ProjectId projectId) {
        return sendRemoveRequest(REMOVE_PROJECT, projectId);
    }
}
