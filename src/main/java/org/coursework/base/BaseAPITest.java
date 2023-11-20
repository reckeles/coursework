package org.coursework.base;

import org.coursework.api.model.user.User;

import static org.coursework.config.EnvConfig.*;

public class BaseAPITest {
//    protected final User admin = new User(ADMIN_USERNAME.value, ADMIN_PASSWORD.value);
    protected final User admin = User.builder()
                                        .username(ADMIN_USERNAME.value)
                                        .password(ADMIN_PASSWORD.value)
                                        .build();
}
