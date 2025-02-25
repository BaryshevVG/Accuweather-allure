package com.example.accuweather.tests;

import io.qameta.allure.*;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@Epic("Тестирование проекта accuweather.com")
@Feature("Тестирование API Astronomy API")
public class SunriseSunsetTest extends BaseTest {

    @Test
    @DisplayName("Тест SunriseSunset(негативный) - получение данных о восходе/заходе солнца")
    @Story("Вызов метода получения данных о восходе/заходе солнца")
    @Description("Негативный тест - проверка получения данных о восходе/заходе солнца")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("https://developer.accuweather.com/accuweather-astronomy-api/apis")
    @Owner("Барышев Вадим")
    public void testSunriseSunsetUnauthorized() {

        given()
                .queryParam("apikey", API_KEY)
                .when()
                .get("/astronomy/v1/295117")
                .then()
                .statusCode(401)
                .contentType(ContentType.JSON)
                .body("Message", equalTo("Api Authorization failed"));
    }
}
