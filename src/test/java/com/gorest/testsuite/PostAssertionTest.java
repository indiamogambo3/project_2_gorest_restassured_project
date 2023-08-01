package com.gorest.testsuite;

import com.gorest.testbase.TestBase;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PostAssertionTest extends TestBase {

    static ValidatableResponse response;


    public PostAssertionTest() {

        response = given()
                .queryParam("page", 1)
                .queryParam("per_page", 25)
                .when()
                .get("/posts")
                .then().statusCode(200);
    }

    //1. Verify the if the total record is 25
    @Test
    public void test001() {
        response.body("size", equalTo(25));
    }

    //2. Verify the if the title of id = 57251 is equal to ”Capio cornu arma baiulus vito.”
    @Test
    public void test002() {
        response.body("findAll{it.id == 57251}.title", hasItem("Capio cornu arma baiulus vito."));
    }

    //3. Check the single user_id in the Array list (4104812)
    @Test
    public void test003() {
        response.body("findAll{it.id}.user_id", hasItem(4104812));
    }

    //4. Check the multiple ids in the ArrayList (57251, 57250,57249)
    @Test
    public void test004() {
        response.body("findAll{it.id}.id", hasItems(57251, 57250, 57249));
    }

    //5. Verify the body of userid = 4104812 is equal “Quas cito veritatis. Cunctatio quidem cras. Doloribus ut vitae. Toties causa advenio. Viscus depono tricesimus. Tui claustrum attollo. Corrupti curis solum. Tero adflicto complectus. Accipio eum crepusculum. Auditor clamo thalassinus. Undique patior accusantium. Absque stillicidium benevolentia. Umbra substantia acerbitas. Et spectaculum tolero. Utor voluptatum coniecto. Virtus bestia vesper. Clam auctus amissio. Acies decens ullus."”
    @Test
    public void test005() {
        response.body("findAll{it.user_id == 4104812}.body", hasItem("Quas cito veritatis. Cunctatio quidem cras. Doloribus ut vitae. Toties causa advenio. Viscus depono tricesimus. Tui claustrum attollo. Corrupti curis solum. Tero adflicto complectus. Accipio eum crepusculum. Auditor clamo thalassinus. Undique patior accusantium. Absque stillicidium benevolentia. Umbra substantia acerbitas. Et spectaculum tolero. Utor voluptatum coniecto. Virtus bestia vesper. Clam auctus amissio. Acies decens ullus."));
    }




}
