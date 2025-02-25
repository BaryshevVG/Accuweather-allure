package com.example.accuweather.tests;

import com.example.Weather.Headline;
import io.qameta.allure.*;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

@Epic("Тестирование проекта accuweather.com")
@Feature("Тестирование API Current Conditions API")
public class HistoricalWeatherTest extends BaseTest {

    @Test
    @DisplayName("Тест HistoricalWeather - получение исторических погодных данных")
    @Story("Получение исторической погоды по API AccuWeather")
    @Description("Этот тест проверяет, что API корректно возвращает исторические данные о погоде для города по указанному ID.")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("https://developer.accuweather.com/accuweather-current-conditions-api")
    @Owner("Барышев Вадим")
    public void testHistoricalWeather() {
        var response = given()
                .queryParam("apikey", API_KEY)
                .when()
                .get("/currentconditions/v1/295117/historical/24")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract()
                .response();

        if (response.statusCode() != 200) {
            System.out.println("Response body: " + response.body().asString());
        }

        assertEquals(200, response.statusCode());
    }
}
