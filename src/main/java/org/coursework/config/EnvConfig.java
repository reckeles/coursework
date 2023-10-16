package org.coursework.config;

import org.coursework.base.BaseConfig;
import org.coursework.config.common.Param;
import org.coursework.config.enums.Environment;

import java.util.Properties;

public class EnvConfig extends BaseConfig {
    static private Environment env = setEnv();

    static final public Param HTTP_BASE_PROTOCOL = new Param("http.base.protocol", "http", true, getEnvProperties(env));
    static final public Param HTTP_BASE_URL = new Param("http.base.url", "localhost", true, getEnvProperties(env));
    static final public Param HTTP_BASE_PORT = new Param("http.base.port", "80", true, getEnvProperties(env));
    static final public Param JSONRPC_VERSION = new Param("api.jsonrpc.version", "2.0", true, getEnvProperties(env));
    static final public Param ADMIN_USERNAME = new Param("admin.username", "admin", true, getEnvProperties(env));
    static final public Param ADMIN_PASSWORD = new Param("admin.password", "admin", true, getEnvProperties(env));

    static private Properties envProperties;


    static private Properties getEnvProperties(Environment env) {
        if (envProperties == null) {
            envProperties = new Properties();
            environmentName = env.getEnvName();
            envProperties.putAll(getResourceProperties("common.properties"));
            envProperties.putAll(getResourceProperties("env/" + environmentName + ".properties"));
        }
        return envProperties;
    }

    static public String getBaseURL() {
        return String.format("%s://%s", EnvConfig.HTTP_BASE_PROTOCOL.value, EnvConfig.HTTP_BASE_URL.value);
    }

    static private Environment setEnv() {
        String property = System.getProperty("env");
        if (property == null) {
            return Environment.LOCAL;
        }
        return Environment.valueOf(property);
    }
}
