package com.gorest.crudtest;

import com.gorest.model.UserPojo;
import com.gorest.testbase.TestBase;
import com.gorest.utils.TestUtils;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class UserCRUDTest extends TestBase {

    @Test
    public void verifyUserCreatedSuccessfully() {
        String email = TestUtils.getRandomValue() + "prime@gmail.com";
        UserPojo userPojo = new UserPojo();
        userPojo.setName("Mukz");
        userPojo.setEmail(email);
        userPojo.setGender("male");
        userPojo.setStatus("active");

        Response response = given()
                .header("Connection", "keep-alive")
                .header("Content-Type", "application/json")
                .when()
                .body(userPojo)
                .post();
        response.prettyPrint();
        response.then().statusCode(201);

    }

}
