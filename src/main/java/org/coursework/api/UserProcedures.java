package org.coursework.api;

import io.qameta.allure.Step;
import org.coursework.model.Authorization;
import org.coursework.model.user.User;
import org.coursework.model.user.UserExtended;
import org.coursework.model.user.UserId;

import static org.coursework.api.APIUtil.*;
import static org.coursework.model.KanboardMethods.*;

public class UserProcedures extends Procedures {

    @Step
    public static User createUser(User user, Authorization authorization) {
        Integer id = sendCreateRequest(CREATE_USER, user, authorization);
        user.setId(id);
        return user;
    }

    @Step
    public static UserExtended getUserById(Integer id, Authorization authorization) {
        return sendGetRequest(GET_USER, new UserId(id), UserExtended.class, authorization);
    }

    @Step
    public static Boolean removeUserById(Integer id, Authorization authorization) {
        return sendRemoveRequest(REMOVE_USER, new UserId(id), authorization);
    }
}
