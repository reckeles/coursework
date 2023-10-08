package org.coursework.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.coursework.model.base.BaseRequestBody;
import org.coursework.model.base.BaseResponse;
import org.coursework.model.user.User;
import org.coursework.model.user.UserExtended;
import org.coursework.model.user.UserId;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import static org.coursework.api.APIUtil.*;
import static org.coursework.model.KanboardMethods.*;

public class UserProcedures extends Procedures {

    @Step
    public static Integer createUser(User user) {
        return sendCreateRequest(CREATE_USER, user);
    }

    @Step
    public static UserExtended getUser(UserId userId) {
        return sendGetRequest(GET_USER, userId, UserExtended.class);
    }

    @Step
    public static Boolean removeUser(UserId userId) {
        return sendRemoveRequest(REMOVE_USER, userId);
    }
}
