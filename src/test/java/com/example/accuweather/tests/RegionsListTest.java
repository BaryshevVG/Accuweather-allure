package com.example.accuweather.tests;

import com.example.Location.Region;
import io.qameta.allure.*;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

@Epic("Тестирование проекта accuweather.com")
@Feature("Тестирование API Location API")
public class RegionsListTest extends BaseTest {

    @Test
    @DisplayName("Тест RegionsList - получение списка регионов")
    @Story("Вызов метода получения списка всех доступных регионов")
    @Description("Этот тест проверяет, что API возвращает список регионов с корректными данными, " +
            "включая уникальные идентификаторы для каждого региона.")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("https://developer.accuweather.com/accuweather-locations-api/apis")
    @Owner("Барышев Вадим")
    public void testRegionsList() {
        List<Region> regions = given()
                .queryParam("apikey", API_KEY)
                .when()
                .get("/locations/v1/regions")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract()
                .jsonPath()
                .getList(".", Region.class);

        assertFalse(regions.isEmpty());
        assertNotNull(regions.get(0).getId());
    }
}
