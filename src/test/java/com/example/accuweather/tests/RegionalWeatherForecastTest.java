package com.example.accuweather.tests;

import io.qameta.allure.*;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.given;

@Epic("Тестирование проекта accuweather.com")
@Feature("Тестирование API Forecast API")
public class RegionalWeatherForecastTest extends BaseTest {

    @Test
    @DisplayName("Тест RegionalWeatherForecast(негативный) - региональный прогноз погоды")
    @Story("Негативный тест - проверка получения регионального прогноза погоды")
    @Description("Этот тест проверяет, что система корректно возвращает ошибку авторизации")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("https://developer.accuweather.com/accuweather-forecasts-api/apis")
    @Owner("Барышев Вадим")
    public void testRegionalWeatherForecastUnauthorized() {

        given()
                .queryParam("apikey", API_KEY)  // Передаем неверный API-ключ
                .when()
                .get("/forecasts/v1/regional/5day/EUR")
                .then()
                .statusCode(401)
                .contentType(ContentType.JSON)
                .body("Message", equalTo("Api Authorization failed"));
    }
}
