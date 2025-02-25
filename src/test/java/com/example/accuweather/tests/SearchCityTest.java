package com.example.accuweather.tests;

import com.example.Location.Location;
import io.qameta.allure.*;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

@Epic("Тестирование проекта accuweather.com")
@Feature("Тестирование API Location API")
public class SearchCityTest extends BaseTest {

    @Test
    @DisplayName("Тест SearchCity - поиск города по названию")
    @Story("Вызов метода поиска города по названию")
    @Description("Этот тест проверяет, что API корректно обрабатывает запрос по названию города " +
            "и возвращает ожидаемые данные для Moscow.")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("https://developer.accuweather.com/accuweather-locations-api/apis")
    @Owner("Барышев Вадим")
    public void testSearchCity() {
        List<Location> cities = given()
                .queryParam("apikey", API_KEY)
                .queryParam("q", "Moscow")
                .when()
                .get("/locations/v1/cities/search")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract()
                .jsonPath()
                .getList(".", Location.class);

        assertFalse(cities.isEmpty());
        assertEquals("Moscow", cities.get(0).getEnglishName());
        assertEquals("RU", cities.get(0).getCountry().getId());
    }
}
