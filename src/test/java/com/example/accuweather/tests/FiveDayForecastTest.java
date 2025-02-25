package com.example.accuweather.tests;

import com.example.Weather.DailyForecast;
import io.qameta.allure.*;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

@Epic("Тестирование проекта accuweather.com")
@Feature("Тестирование API Forecast API")
public class FiveDayForecastTest extends BaseTest {

    @Test
    @DisplayName("Тест FiveDayForecast - получение прогноза погоды на 5 дней для города")
    @Story("Вызов метода получения прогноза погоды на 5 дней для города по ID")
    @Description("Тест проверяет, что API корректно возвращает список из 5 прогнозов погоды " +
            "на 5 дней для города с ID 295117.")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("https://developer.accuweather.com/accuweather-forecast-api/apis")
    @Owner("Барышев Вадим")
    public void testFiveDayForecast() {
        List<DailyForecast> forecast = given()
                .queryParam("apikey", API_KEY)
                .when()
                .get("/forecasts/v1/daily/5day/295117")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract()
                .jsonPath()
                .getList("DailyForecasts", DailyForecast.class);

        assertNotNull(forecast);
        assertEquals(5, forecast.size());
    }
}
