package ru.netology;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

class PostmanEchoTest {

    @Test
    void shouldReturnSendData() {

        given()
                .baseUri("https://postman-echo.com")
                .body("Good morning")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data", equalTo("Good morning"));
    }

    @Test
    void shouldReturnSendDataNegativeTest() {

        given()
                .baseUri("https://postman-echo.com")
                .body("Good morning")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data", equalTo("Hello"));
    }
}