package com.example.accuweather.tests;

import io.qameta.allure.*;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.greaterThan;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

@Epic("Тестирование проекта accuweather.com")
@Feature("Тестирование API Current Weather API")
public class CurrentWeatherTest extends BaseTest {

    @Test
    @DisplayName("Тест CurrentWeather - получение текущей погоды для города")
    @Story("Проверка корректности API для получения текущей погоды по ID города")
    @Description("Тест проверяет, что API корректно возвращает данные о текущей погоде для города по ID" +
            " и содержит хотя бы один элемент.")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("https://developer.accuweather.com/accuweather-current-conditions-api/apis")
    @Owner("Барышев Вадим")
    public void testCurrentWeather() {
        given()
                .queryParam("apikey", API_KEY)
                .when()
                .get("/currentconditions/v1/295117")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("size()", greaterThan(0));
    }
}
