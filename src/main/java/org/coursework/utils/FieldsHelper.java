package org.coursework.utils;

import org.coursework.model.User;

import java.lang.reflect.Field;

public class FieldsHelper {
    public static String getUserUsernameField() {
        try {
            Field field = User.class.getDeclaredField("username");
            return field.getName();
        } catch (NoSuchFieldException e) {
            return null;
        }
    }

    public static String getUserNameField() {
        try {
            Field field = User.class.getDeclaredField("name");
            return field.getName();
        } catch (NoSuchFieldException e) {
            return null;
        }
    }

    public static String getUserRoleField() {
        try {
            Field field = User.class.getDeclaredField("role");
            return field.getName();
        } catch (NoSuchFieldException e) {
            return null;
        }
    }

    public static String getUserEmailField() {
        try {
            Field field = User.class.getDeclaredField("email");
            return field.getName();
        } catch (NoSuchFieldException e) {
            return null;
        }
    }
}
