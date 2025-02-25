package com.example.Weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "LocalObservationDateTime",
        "EpochTime",
        "WeatherText",
        "WeatherIcon",
        "HasPrecipitation",
        "PrecipitationType",
        "IsDayTime",
        "Temperature",
        "MobileLink"
})
public class WeatherData {

    @JsonProperty("LocalObservationDateTime")
    private String localObservationDateTime;

    @JsonProperty("EpochTime")
    private Integer epochTime;

    @JsonProperty("WeatherText")
    private String weatherText;

    @JsonProperty("WeatherIcon")
    private Integer weatherIcon;

    @JsonProperty("HasPrecipitation")
    private Boolean hasPrecipitation;

    @JsonProperty("PrecipitationType")
    private String precipitationType;

    @JsonProperty("IsDayTime")
    private Boolean isDayTime;

    @JsonProperty("Temperature")
    private Temperature temperature;

    @JsonProperty("MobileLink")
    private String mobileLink;

    // Геттеры и сеттеры
    public String getLocalObservationDateTime() {
        return localObservationDateTime;
    }

    public void setLocalObservationDateTime(String localObservationDateTime) {
        this.localObservationDateTime = localObservationDateTime;
    }

    public Integer getEpochTime() {
        return epochTime;
    }

    public void setEpochTime(Integer epochTime) {
        this.epochTime = epochTime;
    }

    public String getWeatherText() {
        return weatherText;
    }

    public void setWeatherText(String weatherText) {
        this.weatherText = weatherText;
    }

    public Integer getWeatherIcon() {
        return weatherIcon;
    }

    public void setWeatherIcon(Integer weatherIcon) {
        this.weatherIcon = weatherIcon;
    }

    public Boolean getHasPrecipitation() {
        return hasPrecipitation;
    }

    public void setHasPrecipitation(Boolean hasPrecipitation) {
        this.hasPrecipitation = hasPrecipitation;
    }

    public String getPrecipitationType() {
        return precipitationType;
    }

    public void setPrecipitationType(String precipitationType) {
        this.precipitationType = precipitationType;
    }

    public Boolean getIsDayTime() {
        return isDayTime;
    }

    public void setIsDayTime(Boolean isDayTime) {
        this.isDayTime = isDayTime;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    public String getMobileLink() {
        return mobileLink;
    }

    public void setMobileLink(String mobileLink) {
        this.mobileLink = mobileLink;
    }

    @Override
    public String toString() {
        return "WeatherData{" +
                "localObservationDateTime='" + localObservationDateTime + '\'' +
                ", epochTime=" + epochTime +
                ", weatherText='" + weatherText + '\'' +
                ", weatherIcon=" + weatherIcon +
                ", hasPrecipitation=" + hasPrecipitation +
                ", precipitationType='" + precipitationType + '\'' +
                ", isDayTime=" + isDayTime +
                ", temperature=" + temperature +
                ", mobileLink='" + mobileLink + '\'' +
                '}';
    }
}
