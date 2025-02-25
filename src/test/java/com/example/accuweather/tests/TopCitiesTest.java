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
public class TopCitiesTest extends BaseTest {

    @Test
    @DisplayName("Тест TopCities - получение списка 50 крупнейших городов")
    @Story("Проверка правильности получения списка из 50 крупнейших городов")
    @Description("Этот тест проверяет, что API возвращает правильный список из 50 крупнейших городов по запросу.")
    @Severity(SeverityLevel.NORMAL)
    @TmsLink("https://developer.accuweather.com/accuweather-locations-api/apis")
    @Owner("Барышев Вадим")
    public void testTopCities() {
        List<Location> cities = given()
                .queryParam("apikey", API_KEY)
                .when()
                .get("/locations/v1/topcities/50")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract()
                .jsonPath()
                .getList(".", Location.class);

        assertEquals(50, cities.size());
    }
}
