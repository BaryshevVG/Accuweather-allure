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
public class GeoLocationSearchTest extends BaseTest {

    @Test
    @DisplayName("Тест GeoLocationSearch - поиск города по координатам")
    @Story("Вызов метода поиска города по географическим координатам в API")
    @Description("Этот тест проверяет, что API возвращает правильный город (Tyumen) по переданным координатам.")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("https://developer.accuweather.com/accuweather-locations-api/apis")
    @Owner("Барышев Вадим")
    public void testGeoLocationSearch() {
        Location location = given()
                .queryParam("apikey", API_KEY)
                .queryParam("q", "57.1522,65.5272") // Координаты Тюмени
                .when()
                .get("/locations/v1/cities/geoposition/search")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract()
                .as(Location.class);

        assertNotNull(location);
        assertEquals("Tyumen", location.getLocalizedName());
        assertEquals("RU", location.getCountry().getId());
    }
}
