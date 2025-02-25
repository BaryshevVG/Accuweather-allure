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
public class Top100CitiesTest extends BaseTest {

    @Test
    @DisplayName("Тест Top100Cities - получение списка 100 крупнейших городов")
    @Story("Проверка правильности получения списка из 100 крупнейших городов")
    @Description("Этот тест проверяет, что API возвращает правильный список из 100 крупнейших городов по запросу.")
    @Severity(SeverityLevel.NORMAL)
    @TmsLink("https://developer.accuweather.com/accuweather-locations-api/apis")
    @Owner("Барышев Вадим")
    public void testTop100Cities() {
        List<Location> cities = given()
                .queryParam("apikey", API_KEY)
                .when()
                .get("/locations/v1/topcities/100")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract()
                .jsonPath()
                .getList(".", Location.class);

        // Проверяем, что в списке ровно 100 городов
        assertEquals(100, cities.size());
    }
}
