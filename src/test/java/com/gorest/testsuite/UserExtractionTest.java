package com.gorest.testsuite;

import com.gorest.testbase.TestBase;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class UserExtractionTest extends TestBase {

    static ValidatableResponse response;


    public UserExtractionTest() {

        response = given()
                .queryParam("page", 1)
                .queryParam("per_page", 20)
                .when()
                .get("/users")
                .then().statusCode(200);
    }

    //1. Extract the All Ids
    @Test
    public void test001() {
        List<?> listOfIds = response.extract().path("id");

        System.out.println("--------------------Start of Test--------------------");
        System.out.println("All the Id's in the list are: " + listOfIds);
        System.out.println("---------------------End of Test---------------------");
    }

    //2. Extract the all Names
    @Test
    public void test002() {
        List<?> listOfNames = response.extract().path("name");

        System.out.println("--------------------Start of Test--------------------");
        System.out.println("All the Names in the list are: " + listOfNames);
        System.out.println("---------------------End of Test---------------------");
    }
    //3. Extract the name of 5th object
    @Test
    public void test003() {
        String name = response.extract().path("[4].name");

        System.out.println("--------------------Start of Test--------------------");
        System.out.println("5th name in the list is: " + name);
        System.out.println("---------------------End of Test---------------------");
    }

    //4. Extract the names of all object whose status = inactive
    @Test
    public void test004() {
        List<HashMap<String, ?>> statusInactive = response.extract().path("findAll{it.status == 'inactive'}.name");

        System.out.println("--------------------Start of Test--------------------");
        System.out.println("Names of all whose status is inactive are: " + statusInactive);
        System.out.println("---------------------End of Test---------------------");
    }

    //5. Extract the gender of all the object whose status = active
    @Test
    public void test005() {
        List<HashMap<String, ?>> statusActive = response.extract().path("findAll{it.status == 'active'}.gender");

        System.out.println("--------------------Start of Test--------------------");
        System.out.println("Gender of all whose status is active are: " + statusActive);
        System.out.println("---------------------End of Test---------------------");
    }

    //6. Print the names of the object whose gender = female
    @Test
    public void test006() {
        List<HashMap<String, ?>> genderFemale = response.extract().path("findAll{it.gender == 'female'}.name");

        System.out.println("--------------------Start of Test--------------------");
        System.out.println("Names of all whose gender is female are: " + genderFemale);
        System.out.println("---------------------End of Test---------------------");
    }

    //7. Get all the emails of the object where status = inactive
    @Test
    public void test007() {
        List<HashMap<String, ?>> emails = response.extract().path("findAll{it.status == 'inactive'}.email");

        System.out.println("--------------------Start of Test--------------------");
        System.out.println("Get emails of all inactive status are: " + emails);
        System.out.println("---------------------End of Test---------------------");
    }

    //8. Get the ids of the object where gender = male
    @Test
    public void test008() {
        List<HashMap<String, ?>> ids = response.extract().path("findAll{it.gender == 'male'}.id");

        System.out.println("--------------------Start of Test--------------------");
        System.out.println("Id's where gender is male are: " + ids);
        System.out.println("---------------------End of Test---------------------");
    }

    //9. Get all the status
    @Test
    public void test009() {
        List<?> allStatus = response.extract().path("status");

        System.out.println("--------------------Start of Test--------------------");
        System.out.println("All the status are: " + allStatus);
        System.out.println("---------------------End of Test---------------------");
    }

    //10. Get email of the object where name = Dharani Kocchar
    @Test
    public void test010() {
        List<HashMap<String, ?>> email = response.extract().path("findAll{it.name == 'Dharani Kocchar'}.email");

        System.out.println("--------------------Start of Test--------------------");
        System.out.println("Email of Dharani Kocchar is: " + email);
        System.out.println("---------------------End of Test---------------------");
    }

    //11. Get gender of id = 4040685
    @Test
    public void test011() {
        List<HashMap<String, ?>> gender = response.extract().path("findAll{it.id == 4040685}.gender");

        System.out.println("--------------------Start of Test--------------------");
        System.out.println("Gender of Id 4040685 is: " + gender);
        System.out.println("---------------------End of Test---------------------");
    }




}
