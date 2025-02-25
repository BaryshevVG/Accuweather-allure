package com.example.accuweather.tests;

import com.example.Weather.DailyForecast;
import io.qameta.allure.*;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List; // Импортируем List

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

@Epic("Тестирование проекта accuweather.com")
@Feature("Тестирование API Forecast API")
public class OneDayForecastTest extends BaseTest {

    @Test
    @DisplayName("Тест OneDayForecast - получение прогноз на один день")
    @Story("Вызов метода получения прогноза погоды на один день")
    @Description("Этот тест проверяет, что API корректно возвращает прогноз погоды на один день для города Tyumen.")
    @Severity(SeverityLevel.NORMAL)
    @TmsLink("https://developer.accuweather.com/accuweather-forecasts-api")
    @Owner("Барышев Вадим")
    public void testOneDayForecast() {
        List<DailyForecast> forecast = given()
                .queryParam("apikey", API_KEY)
                .when()
                .get("/forecasts/v1/daily/1day/295117")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract()
                .jsonPath()
                .getList("DailyForecasts", DailyForecast.class);

        assertNotNull(forecast);
        assertEquals(1, forecast.size());
    }
}
