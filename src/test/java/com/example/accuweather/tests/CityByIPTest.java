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
public class CityByIPTest extends BaseTest {

    @Test
    @DisplayName("Тест CityByIP - поиск города по IP-адресу")
    @Story("Вызов метода поиска города по IP-адресу")
    @Description("Этот тест проверяет, что API возвращает правильную информацию о городе по указанному IP-адресу.")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("https://developer.accuweather.com/accuweather-locations-api/apis")
    @Owner("Барышев Вадим")
    public void testFindCityByIP() {
        Location location = given()
                .queryParam("apikey", API_KEY)
                .queryParam("q", "2.59.241.32")
                .when()
                .get("/locations/v1/cities/ipaddress")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract()
                .as(Location.class);

        assertNotNull(location.getLocalizedName(), "Название города не должно быть null");

        assertNotNull(location.getCountry().getId(), "ID страны не должно быть null");
    }
}
