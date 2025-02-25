package com.example.accuweather.tests;

import com.example.Location.AdministrativeArea;
import io.qameta.allure.*;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

@Epic("Тестирование проекта accuweather.com")
@Feature("Тестирование API Location API")
public class AdminAreasTest extends BaseTest {

    @Test
    @DisplayName("Тест AdminAreas - получение списка административных районов")
    @Story("Вызов метода получения списка административных районов")
    @Description("Этот тест проверяет, что API возвращает список административных районов России")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("https://developer.accuweather.com/accuweather-locations-api/apis")
    @Owner("Барышев Вадим")
    public void testAdminAreas() {
        List<AdministrativeArea> areas = given()
                .queryParam("apikey", API_KEY)
                .when()
                .get("/locations/v1/adminareas/RU")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract()
                .jsonPath()
                .getList(".", AdministrativeArea.class);

        assertFalse(areas.isEmpty());
        assertEquals("RU", areas.get(0).getCountryID());
    }
}
