package com.itacademy.finalproject.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupTests {


    @Test
    public void signupTest() {
        RestAssured.baseURI = "https://api.iticket.az/";

        String requestBody = """
              {
              "first_name":"",
              "last_name":"test",
              "password":"12345678",
              "mobile":"user",
              "email":"test@aist.group",
              "cart_id":"d27120b6-74f2-11ef-a47d-7e416d34cd6b"
              }
                """;


        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/ru/v5/user/auth/register")
                .then()
                .extract().response();


        Assert.assertEquals(response.getStatusCode(), 422);
    }

    @Test
    public void signupTest2() {
        RestAssured.baseURI = "https://api.iticket.az/";

        String requestBody = """
              {
              "first_name":"",
              "last_name":"test",
              "password":"12345678",
              "mobile":"user",
              "email":"test@aist.group",
              "cart_id":"d27120b6-74f2-11ef-a47d-7e416d34cd6b"
              }
                """;


        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/ru/v5/user/auth/register")
                .then()
                .extract().response();


        Assert.assertEquals(response.getStatusCode(), 422);

    }
}
