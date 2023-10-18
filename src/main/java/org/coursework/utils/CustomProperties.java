package org.coursework.utils;

public class CustomProperties {
    public static String getCustomProperty(String propertyName, String defaultValue){
        String property = System.getProperty(propertyName);
        if (property == null) {
            return defaultValue;
        }
        return property;
    }
}
