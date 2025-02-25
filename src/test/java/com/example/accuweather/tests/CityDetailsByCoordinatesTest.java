package com.example.accuweather.tests;

import com.example.Location.Location;
import io.qameta.allure.*;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

@Epic("Тестирование проекта accuweather.com")
@Feature("Тестирование API Location API")
public class CityDetailsByCoordinatesTest extends BaseTest {

    @Test
    @DisplayName("Тест CityDetailsByCoordinates - получение данных о городе по координатам")
    @Story("Вызов метода получения данных о городе по географическим координатам")
    @Description("Этот тест проверяет, что API возвращает корректные данные о городе Тюмень, используя координаты.")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("https://developer.accuweather.com/accuweather-locations-api/apis")
    @Owner("Барышев Вадим")
    public void testCityDetailsByCoordinates() {
        Location location = given()
                .queryParam("apikey", API_KEY)
                .queryParam("q", "57.152985,65.541227")
                .when()
                .get("/locations/v1/cities/geoposition/search")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract()
                .as(Location.class);

        assertEquals("Tyumen", location.getEnglishName(), "Город должен быть Тюмень");

        assertEquals("RU", location.getCountry().getId(), "Страна должна быть Россия");
    }
}
