package org.coursework.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.coursework.base.BaseAPITest;
import org.coursework.model.user.User;

import static org.coursework.config.EnvConfig.API_PASSWORD;
import static org.coursework.config.EnvConfig.API_USERNAME;

public class RequestSender {
    public static <T> Response sendRequest(T body){
        return RestAssured.given().auth()
                .basic(API_USERNAME.value, API_PASSWORD.value)
                .and()
                .contentType(ContentType.JSON)
                .and()
                .body(body)
                .when()
                .post(BaseAPITest.getAPIURL())
                .then()
                .statusCode(200)
                .extract().response();
    }

    public static <T> Response sendRequest(T body, User user){
        return RestAssured.given().auth()
                .basic(user.getUsername(), user.getPassword())
                .and()
                .contentType(ContentType.JSON)
                .and()
                .body(body)
                .when()
                .post(BaseAPITest.getAPIURL())
                .then()
                .statusCode(200)
                .extract().response();
    }
}
