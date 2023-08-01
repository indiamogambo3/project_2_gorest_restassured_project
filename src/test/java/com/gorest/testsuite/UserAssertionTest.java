package com.gorest.testsuite;

import com.gorest.testbase.TestBase;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class UserAssertionTest extends TestBase {

    static ValidatableResponse response;


    public UserAssertionTest() {

        response = given()
                .queryParam("page", 1)
                .queryParam("per_page", 20)
                .when()
                .get("/users")
                .then().statusCode(200);
    }

    //1. Verify the if the total record is 20
    @Test
    public void test001() {
        response.body("size", equalTo(20));
    }

    //2. Verify the name of id = 4040691 is equal to ”Chaturbhuj Reddy”
    @Test
    public void test002() {
        response.body("findAll{it.id == 4040691}.name", equalTo("Chaturbhuj Reddy"));
    }

    //3. Check the single ‘Name’ in the Array list (Chaturbhuj Reddy)
    @Test
    public void test003() {
        response.body("name",hasItem("Chaturbhuj Reddy"));
    }

    //4. Check the multiple ‘Names’ in the ArrayList (Tushar Ahluwalia, Jahnu Abbott, Achyut Desai CPA)
    @Test
    public void test004() {
        response.body("name", hasItems("Tushar Ahluwalia", "Jahnu Abbott", "Achyut Desai CPA"));
    }

    //5. Verify the email of userid = 4040686 is equal “chaturvedi_bhima@barrows.example”
    @Test
    public void test005() {
        response.body("findAll{it.id == 4040686}.email", equalTo("chaturvedi_bhima@barrows.example"));
    }

    //6. Verify the status is “Active” of user name is “Esha Abbott MD”
    @Test
    public void test006() {
        response.body("findAll{it.name == 'Esha Abbott MD'}.status", equalTo("active"));
    }

    //7. Verify the Gender = male of user name is “Saraswati Dhawan”
    @Test
    public void test007() {
        response.body("findAll{it.name == 'Saraswati Dhawan'}.gender", equalTo("male"));
    }













}
