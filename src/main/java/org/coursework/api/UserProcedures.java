package org.coursework.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.coursework.base.BaseAPITest;
import org.coursework.model.*;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import static org.coursework.model.KanboardMethods.*;

public class UserProcedures {
    @Step
    public static Integer createUser(User user)  {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            System.out.println(mapper.writeValueAsString(user));

        } catch (JsonProcessingException e){

        }

        BaseRequestBody<User> base = new BaseRequestBody<>(CREATE_USER.getMethod(), CREATE_USER.getId(), user);

        Response response = RestAssured.given().auth()
                .basic("admin", "admin")
                .and()
                .contentType(ContentType.JSON)
                .and()
                .body(base)
                .when()
                .post(BaseAPITest.getAPIURL())
                .then()
                .statusCode(200)
                .extract().response();

        BaseResponse<?> answer = response.getBody().as(BaseResponse.class);
        var result = answer.getResult();
        if (result instanceof Boolean || result == null){
            System.out.println(((Boolean) result).booleanValue());
            return null;
        } else {
            System.out.println(((Integer) result).intValue());
            return (Integer) result;
        }
    }

    @Step
    public static UserExtended getUser(UserId userId){
        BaseRequestBody<UserId> base = new BaseRequestBody<>(GET_USER.getMethod(), GET_USER.getId(), userId);

        Response response = RestAssured.given().auth()
                .basic("admin", "admin")
                .and()
                .contentType(ContentType.JSON)
                .and()
                .body(base)
                .when()
                .post(BaseAPITest.getAPIURL())
                .then()
                .statusCode(200)
                .extract().response();

        BaseResponse<UserExtended> answer = response.getBody().as(BaseResponse.class);

        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(
                answer.getResult(),
                new TypeReference<UserExtended>(){}
        );
    }

    @Step
    public static Boolean removeUser(UserId userId){
        BaseRequestBody<UserId> base = new BaseRequestBody<>(DELETE_USER.getMethod(), DELETE_USER.getId(), userId);

        Response response = RestAssured.given().auth()
                .basic("admin", "admin")
                .and()
                .contentType(ContentType.JSON)
                .and()
                .body(base)
                .when()
                .post(BaseAPITest.getAPIURL())
                .then()
                .statusCode(200)
                .extract().response();

        BaseResponse<Boolean> answer = response.getBody().as(BaseResponse.class);
        return answer.getResult();
    }

    @Step
    public static void userIsCreated(Integer id){
        Assert.assertNotNull(id, "User is not created");
    }

    @Step
    public static void userIsRemoved(boolean flag){
        Assert.assertTrue(flag, "User is not deleted");
    }

    @Step("Created user's {field} is same as expected")
    public static void assertUserField(String actual, String expected, String field){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actual, expected);
    }
}
