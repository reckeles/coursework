package org.coursework.api;

import org.coursework.model.user.User;
import org.coursework.model.user.UserId;
import org.coursework.model.user.UserExtended;
import org.coursework.utils.FieldsHelper;
import org.testng.annotations.Test;

import java.util.Random;

public class UserTest {
    @Test
    public void userFlow() {
        Random rand = new Random();
        int int_random = rand.nextInt(1000);
        User user = new User("newuser"+int_random, "password_123", "Yuliia", "yuliia@gmail.com", "user");

        Integer userId = UserProcedures.createUser(user);
        UserProcedures.itemIsCreated(userId);

        UserId userIdRequestBody = new UserId(userId);
        UserExtended userInfo = UserProcedures.getUser(userIdRequestBody);

        UserProcedures.assertItemField(user.getUsername(), userInfo.getUsername(), FieldsHelper.getUserUsernameField());
        UserProcedures.assertItemField(user.getName(), userInfo.getName(), FieldsHelper.getUserNameField());
        UserProcedures.assertItemField(user.getEmail(), userInfo.getEmail(), FieldsHelper.getUserEmailField());
        UserProcedures.assertItemField(user.getRole(), userInfo.getRole(), FieldsHelper.getUserRoleField());

        boolean isUserRemoved = UserProcedures.removeUser(userIdRequestBody);
        UserProcedures.itemRemovingRequestIsSuccessful(isUserRemoved);

        UserExtended userInfoAfterRemoving = UserProcedures.getUser(userIdRequestBody);
        UserProcedures.itemIsRemoved(userInfoAfterRemoving);
    }
}
