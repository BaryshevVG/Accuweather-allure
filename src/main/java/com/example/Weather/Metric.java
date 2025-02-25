package com.example.Weather;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Metric {

    private double value;
    private String unit;
    private int unitType;

    // Конструктор по умолчанию для Jackson
    public Metric() {
    }

    // Конструктор с параметрами
    @JsonCreator
    public Metric(@JsonProperty("Value") double value,
                  @JsonProperty("Unit") String unit,
                  @JsonProperty("UnitType") int unitType) {
        this.value = value;
        this.unit = unit;
        this.unitType = unitType;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getUnitType() {
        return unitType;
    }

    public void setUnitType(int unitType) {
        this.unitType = unitType;
    }
}
