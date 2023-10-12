package org.coursework.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

public class EnvConfig extends BaseConfig {
    static private Environment env = setEnv();
//    static final private List<Param> _paramsList = new LinkedList<>();

    static final public Param HTTP_BASE_PROTOCOL = new Param("http.base.protocol", "http", true, getEnvProperties(env));
    static final public Param HTTP_BASE_URL     = new Param("http.base.url",    "localhost", true, getEnvProperties(env));
    static final public Param HTTP_BASE_PORT    = new Param("http.base.port",   "80",      true, getEnvProperties(env));
    static final public Param JSONRPC_VERSION = new Param("api.jsonrpc.version", "2.0", true, getEnvProperties(env));
    static final public Param API_USERNAME = new Param("api.username", "admin", true, getEnvProperties(env));
    static final public Param API_PASSWORD = new Param("api.password", "admin", true, getEnvProperties(env));




    static private Properties envProperties;


    static private Properties getEnvProperties(Environment env) {
        if (envProperties == null) {
            envProperties = new Properties();
            environmentName = env.getEnvName();
            envProperties.putAll(getResourceProperties("common.properties"));
            envProperties.putAll(getResourceProperties("env/" + environmentName + ".properties"));
            //envProperties.putAll(getResourceProperties("allure.properties"));
        }
        return envProperties;
    }

    static public String getBaseURL(){
        return String.format("http://%s:%s", EnvConfig.HTTP_BASE_URL.value, EnvConfig.HTTP_BASE_PORT.value);
    }

    static private Environment setEnv(){
        String property = System.getProperty("env");
        if(property == null){
            return  Environment.LOCAL;
        }
        return Environment.valueOf(property);
    }
}
