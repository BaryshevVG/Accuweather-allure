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
public class POISearchTest extends BaseTest {

    @Test
    @DisplayName("Тест POISearch - поиск точек интереса")
    @Story("Вызов метода поиска POI по запросу 'London'")
    @Description("Этот тест проверяет, что API корректно возвращает результаты для запроса 'London' при поиске POI")
    @Severity(SeverityLevel.NORMAL)
    @TmsLink("https://developer.accuweather.com/accuweather-locations-api/apis")
    @Owner("Барышев Вадим")
    public void testPOISearchInRussia() {
        List<Location> pois = given()
                .queryParam("apikey", API_KEY)
                .queryParam("q", "London")
                .when()
                .get("/locations/v1/poi/search")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract()
                .jsonPath()
                .getList(".", Location.class);

        assertFalse(pois.isEmpty());
    }
}
