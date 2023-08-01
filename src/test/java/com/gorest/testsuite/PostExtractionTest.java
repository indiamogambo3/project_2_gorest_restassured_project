package com.gorest.testsuite;

import com.gorest.testbase.TestBase;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class PostExtractionTest extends TestBase {

    static ValidatableResponse response;


    public PostExtractionTest() {

        response = given()
                .queryParam("page", 1)
                .queryParam("per_page", 25)
                .when()
                .get("/posts")
                .then().statusCode(200);
    }

    //1. Extract the title
    @Test
    public void test001() {
        List<?> title = response.extract().path("title");

        System.out.println("--------------------Start of Test--------------------");
        System.out.println("List of the titles are: " + title);
        System.out.println("---------------------End of Test---------------------");
    }

    //2. Extract the total number of record
    @Test
    public void test002() {
        int total = response.extract().path("total.size");

        System.out.println("--------------------Start of Test--------------------");
        System.out.println("List of total records is: " + total);
        System.out.println("---------------------End of Test---------------------");
    }

    //3. Extract the body of 15th record
    @Test
    public void test003() {
        String body = response.extract().path("[14].body");

        System.out.println("--------------------Start of Test--------------------");
        System.out.println("The body of 15th record is: " + body);
        System.out.println("---------------------End of Test---------------------");
    }

    //4. Extract the user_id of all the records
    @Test
    public void test004() {
        List<HashMap<String, ?>> userId = response.extract().path("user_id");

        System.out.println("--------------------Start of Test--------------------");
        System.out.println("User id's of all records are: " + userId);
        System.out.println("---------------------End of Test---------------------");
    }
    //5. Extract the title of all the records
    @Test
    public void test005(){
        List<HashMap<String, ?>> allTitle = response.extract().path("title");

        System.out.println("--------------------Start of Test--------------------");
        System.out.println("Title of all the records are: " + allTitle);
        System.out.println("---------------------End of Test---------------------");
    }

    //6. Extract the title of all records whose user_id = 4104812
    @Test
    public void test006() {
        List<?> title = response.extract().path("findAll{it.user_id == 4104812}.title");

        System.out.println("--------------------Start of Test--------------------");
        System.out.println("Title of all the records whose id is 4104812 is: " + title);
        System.out.println("---------------------End of Test---------------------");
    }

    //7. Extract the body of all records whose id = 57251
    @Test
    public void test007() {
        List<?> body = response.extract().path("findAll{it.id == 57251}.body");

        System.out.println("--------------------Start of Test--------------------");
        System.out.println("Body of all the records whose id is 57251 is: " + body);
        System.out.println("---------------------End of Test---------------------");
    }


}
