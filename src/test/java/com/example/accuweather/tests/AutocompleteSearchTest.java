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
public class AutocompleteSearchTest extends BaseTest {

    @Test
    @DisplayName("Тест AutocompleteSearch - поиск города с автодополнением")
    @Story("Вызов метода поиска города с автодополнением по строке запроса, проверка наличия города Tyumen")
    @Description("Этот тест проверяет, что API корректно возвращает Tyumen, при поиске по запросу 'Ty'")
    @Severity(SeverityLevel.NORMAL)
    @TmsLink("https://developer.accuweather.com/accuweather-locations-api/apis")
    @Owner("Барышев Вадим")
    public void testAutocompleteSearch() {
        List<Location> cities = given()
                .queryParam("apikey", API_KEY)
                .queryParam("q", "Ty")
                .when()
                .get("/locations/v1/cities/autocomplete")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract()
                .jsonPath()
                .getList(".", Location.class);

        assertFalse(cities.isEmpty());
        assertTrue(cities.get(0).getLocalizedName().startsWith("Tyumen"));
    }
}
