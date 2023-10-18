package org.coursework.utils;

import org.apache.commons.lang3.RandomStringUtils;
import org.coursework.api.model.project.Project;
import org.coursework.api.model.task.Task;
import org.coursework.api.model.user.User;

import java.util.Random;

public class TestData {
    private final static String ADMIN_ROLE = "app-admin";
    private final static String MANAGER_ROLE = "app-manager";
    private final static String USER_ROLE = "app-user";

    private static int getRandomInt() {
        Random rand = new Random();
        return rand.nextInt(100000);
    }

    private static int getRandomInt(int range) {
        Random rand = new Random();
        return rand.nextInt(range);
    }

    public static String getRandomStr() {
        int length = getRandomInt(50);
        boolean useLetters = true;
        boolean useNumbers = false;
        return RandomStringUtils.random(length, useLetters, useNumbers);
    }

    public static User generateDefaultUserData() {
        return new User("newuser" + getRandomInt(), "password_123", "Yuliia", "yuliia@gmail.com", ADMIN_ROLE);
    }

    public static Project generateDefaultProjectData() {
        return new Project("project" + getRandomInt());
    }

    public static Project generateProjectWithOwnerData(Integer userId) {
        return new Project("project" + getRandomInt(), userId);
    }

    public static Task generateDefaultTaskData(Integer projectId) {
        return new Task("task" + getRandomInt(), projectId);
    }

}
