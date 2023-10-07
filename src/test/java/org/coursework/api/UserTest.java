package org.coursework.api;

import org.coursework.model.User;
import org.coursework.model.UserId;
import org.coursework.model.UserExtended;
import org.coursework.utils.FieldsHelper;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class UserTest {

    Integer userId;
    User user;
    @BeforeMethod
    public void before(){
        Random rand = new Random();
        int int_random = rand.nextInt(1000);
        user = new User("newuser"+int_random, "password_123", "Yuliia", "yuliia@gmail.com", "user");

        userId = UserProcedures.createUser(user);
        UserProcedures.userIsCreated(userId);
    }
    @Test
    public void createUser() {
//        Random rand = new Random();
//        int int_random = rand.nextInt(1000);
//        User user = new User("newuser"+int_random, "password_123", "Yuliia", "yuliia@gmail.com", "user");
//
//        Integer userId = UserProcedures.createUser(user);
//        UserProcedures.userIsCreated(userId);

        UserId userIdRequestBody = new UserId(userId);
        UserExtended userInfo = UserProcedures.getUser(userIdRequestBody);

        UserProcedures.assertUserField(user.getUsername(), userInfo.getUsername(), FieldsHelper.getUserUsernameField());
        UserProcedures.assertUserField(user.getName(), userInfo.getName(), FieldsHelper.getUserNameField());
        UserProcedures.assertUserField(user.getEmail(), userInfo.getEmail(), FieldsHelper.getUserEmailField());
        UserProcedures.assertUserField(user.getRole(), userInfo.getRole(), FieldsHelper.getUserRoleField());
    }

    @Test
    public void removeUser(){
//        //before
//        Random rand = new Random();
//        int int_random = rand.nextInt(1000);
//        User user = new User("newuser"+int_random, "password_123", "Yuliia", "yuliia@gmail.com", "user");
//        Integer userId = UserProcedures.createUser(user);
//        UserProcedures.userIsCreated(userId);
//        int userId = beforeRemoveUser();
        //test
        UserId userIdRequestBody = new UserId(userId);
        boolean isUserRemoved = UserProcedures.removeUser(userIdRequestBody);
        UserProcedures.userIsRemoved(isUserRemoved);
    }

//    private int beforeRemoveUser(){
//        Random rand = new Random();
//        int int_random = rand.nextInt(1000);
////        User user = new User("newuser", "password_123", "Yuliia", "yuliia@gmail.com", "user");
//        User user = new User("newuser", "password_123", null, null, null);
//        Integer userId = UserProcedures.createUser(user);
//        UserProcedures.userIsCreated(userId);
//        return userId;
//    }
}
