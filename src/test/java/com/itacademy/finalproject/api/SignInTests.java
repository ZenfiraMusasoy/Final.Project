package com.itacademy.finalproject.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.Test;

@Slf4j
public class SignInTests {

    @Test
    public void validationTest() {
        log.info("Test");
        RestAssured.baseURI = "https://api.iticket.az";

        String requestBody = """
                {
                "email":"test@gmail.com",
                "password":"fff5",
                "cart_id":"d57a38b0-74de-11ef-a142-9e3b692898ae"
                }
                """;


        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/az/v5/user/auth/token")
                .then()
                .extract().response();

        Assert.assertEquals(response.getStatusCode(), 422);
    }


    @Test
    public void successUserAuth() {
        RestAssured.baseURI = "https://api.iticket.az";

        String requestBody = """
                {
                "email":"zenfira.musasoy@aist.group",
                "password":"12345678",
                "cart_id":"e03a025c-74ee-11ef-9133-9e3b692898ae"
            
                }
                """;


        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/az/v5/user/auth/token")
                .then()
                .extract().response();

        Assert.assertEquals(response.getStatusCode(), 200);
    }
}





