package org.coursework.config;

import org.coursework.base.BaseConfig;
import org.coursework.config.common.Param;
import org.coursework.config.enums.TextLocale;

import java.util.Properties;

public class TextConfig extends BaseConfig {
    static private TextLocale locale = setLocale();

    static final public Param LOGIN_PAGE_BAD_CREDS_ALERT = new Param("login.badCredsAlert", "Bad username or password", true, getEnvProperties(locale));
    static final public Param TASK_STATUS_CLOSED_LABEL = new Param("task.status.closed", "closed", true, getEnvProperties(locale));


    static private Properties envProperties;


    static private Properties getEnvProperties(TextLocale locale) {
        if (envProperties == null) {
            envProperties = new Properties();
            environmentName = locale.getLocale();
            envProperties.putAll(getResourceProperties("common.properties"));
            envProperties.putAll(getResourceProperties("texts/" + environmentName + ".properties"));
        }
        return envProperties;
    }

    static private TextLocale setLocale() {
        String property = System.getProperty("locale");
        if (property == null) {
            return TextLocale.EN;
        }
        return TextLocale.valueOf(property);
    }
}
