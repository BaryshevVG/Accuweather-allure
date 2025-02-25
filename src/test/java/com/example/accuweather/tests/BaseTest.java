package com.example.accuweather.tests;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {
    protected static final String BASE_URL = "http://dataservice.accuweather.com";
    protected static final String API_KEY = "BkiJ8048Pu7siquAiuPr8yCNm2QXr1ng";

    @BeforeAll
    static void setup() {
        RestAssured.baseURI = BASE_URL;
    }
}
