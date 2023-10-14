package org.coursework.base;

import org.coursework.model.user.User;

import static org.coursework.config.EnvConfig.*;

public class BaseAPITest {
    protected final User admin = new User(ADMIN_USERNAME.value, ADMIN_PASSWORD.value);
}
