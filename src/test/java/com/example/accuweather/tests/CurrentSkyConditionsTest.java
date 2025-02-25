package com.example.accuweather.tests;

import io.qameta.allure.*;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

@Epic("Тестирование проекта accuweather.com")
@Feature("Тестирование API Current Conditions API")
public class CurrentSkyConditionsTest extends BaseTest {

    @Test
    @DisplayName("Тест CurrentSkyConditions - получение текущих погодных условий")
    @Story("Вызов метода получения текущих погодных условий для города")
    @Description("Этот тест проверяет, что API возвращает правильный статус и формат данных " +
            "для текущих погодных условий города по ID.")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("https://developer.accuweather.com/accuweather-current-conditions-api/apis")
    @Owner("Барышев Вадим")
    public void testCurrentSkyConditions() {
        given()
                .queryParam("apikey", API_KEY)
                .when()
                .get("/currentconditions/v1/295117")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON);
    }
}
