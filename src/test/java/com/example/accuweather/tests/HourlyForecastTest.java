package com.example.accuweather.tests;

import com.example.Weather.Temperature;
import io.qameta.allure.*;
import java.util.List;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

@Epic("Тестирование проекта accuweather.com")
@Feature("Тестирование API Forecast API")
public class HourlyForecastTest extends BaseTest {

    @Test
    @DisplayName("Тест HourlyForecast - получение прогноза погоды на 12 часов")
    @Story("Вызов запроса получения прогноза погоды на ближайшие 12 часов")
    @Description("Этот тест проверяет, что API корректно возвращает прогноз погоды на 12 часов для указанного города.")
    @Severity(SeverityLevel.NORMAL)
    @TmsLink("https://developer.accuweather.com/accuweather-forecast-api")
    @Owner("Барышев Вадим")
    public void testHourlyForecast() {
        List<Temperature> hourlyForecast = given()
                .queryParam("apikey", API_KEY)
                .when()
                .get("/forecasts/v1/hourly/12hour/295117")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract()
                .jsonPath()
                .getList("Temperature", Temperature.class);

        assertNotNull(hourlyForecast);
        assertFalse(hourlyForecast.isEmpty());
    }
}
