package com.example.accuweather.tests;

import com.example.Location.Location;
import io.qameta.allure.*;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List; // Импортируем List

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

@Epic("Тестирование проекта accuweather.com")
@Feature("Тестирование API Location API")
public class NeighboringCitiesTest extends BaseTest {

    @Test
    @DisplayName("Тест NeighboringCities - получение соседних городов")
    @Story("Получение списка соседних городов для заданного города")
    @Description("Этот тест проверяет, что API корректно возвращает список соседних городов для Tyumen.")
    @Severity(SeverityLevel.NORMAL)
    @TmsLink("https://developer.accuweather.com/accuweather-locations-api")
    @Owner("Барышев Вадим")
    public void testNeighboringCities() {
        List<Location> cities = given()
                .queryParam("apikey", API_KEY)
                .when()
                .get("/locations/v1/cities/neighbors/295117")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract()
                .jsonPath()
                .getList(".", Location.class);


        assertFalse(cities.isEmpty());
        assertNotNull(cities.get(0).getLocalizedName());
    }
}
