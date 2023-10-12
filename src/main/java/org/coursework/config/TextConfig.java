package org.coursework.config;

import java.util.Properties;

public class TextConfig extends BaseConfig{
    static private TextLocale locale = setLocale();
//    static final private List<Param> _paramsList = new LinkedList<>();

    static final public Param LOGIN_PAGE_BAD_CREDS_ALERT = new Param("login.badCredsAlert", "Bad username or password", true, getEnvProperties(locale));



    static private Properties envProperties;


    static private Properties getEnvProperties(TextLocale locale) {
        if (envProperties == null) {
            envProperties = new Properties();
            environmentName = locale.getLocale();
            envProperties.putAll(getResourceProperties("common.properties"));
            envProperties.putAll(getResourceProperties("texts/" + environmentName + ".properties"));
            //envProperties.putAll(getResourceProperties("allure.properties"));
        }
        return envProperties;
    }

    static private TextLocale setLocale(){
        String property = System.getProperty("locale");
        if(property == null){
            return  TextLocale.EN;
        }
        return TextLocale.valueOf(property);
    }
}
