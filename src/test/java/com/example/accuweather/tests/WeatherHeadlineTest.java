package com.example.accuweather.tests;

import com.example.Weather.Headline;
import io.qameta.allure.*;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

@Epic("Тестирование проекта accuweather.com")
@Feature("Тестирование API Forecast API")
public class WeatherHeadlineTest extends BaseTest {

    @Test
    @DisplayName("Тест testWeatherHeadline - получение заголовка прогноза погоды на день")
    @Story("Вызов метода получения заголовка прогноза для конкретного дня")
    @Description("Этот тест проверяет получение заголовка прогноза погоды для Tyumen на один день и его корректность.")
    @Severity(SeverityLevel.NORMAL)
    @TmsLink("https://developer.accuweather.com/accuweather-forecasts-api/apis")
    @Owner("Барышев Вадим")
    public void testWeatherHeadline() {
        Headline headline = given()
                .queryParam("apikey", API_KEY)
                .queryParam("language", "ru")
                .when()
                .get("/forecasts/v1/daily/1day/295117")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract()
                .jsonPath()
                .getObject("Headline", Headline.class);

        assertNotNull(headline);
        assertNotNull(headline.getText(), "Текст заголовка не должен быть null");  // Проверка, что текст заголовка не null
        assertNotNull(headline.getEffectiveDate(), "Дата вступления в силу не должна быть null");  // Проверка, что дата вступления в силу не null
    }
}
