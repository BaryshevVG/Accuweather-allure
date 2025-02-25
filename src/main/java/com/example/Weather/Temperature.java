package com.example.Weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonIgnoreProperties(ignoreUnknown = true) // Игнорировать незнакомые поля
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Minimum",
        "Maximum",
        "Metric"
})
public class Temperature {

    @JsonProperty("Minimum")
    private Minimum minimum;

    @JsonProperty("Maximum")
    private Maximum maximum;

    @JsonProperty("Metric")
    private Metric metric;  // Поле Metric

    @JsonProperty("Minimum")
    public Minimum getMinimum() {
        return minimum;
    }

    @JsonProperty("Minimum")
    public void setMinimum(Minimum minimum) {
        this.minimum = minimum;
    }

    @JsonProperty("Maximum")
    public Maximum getMaximum() {
        return maximum;
    }

    @JsonProperty("Maximum")
    public void setMaximum(Maximum maximum) {
        this.maximum = maximum;
    }

    @JsonProperty("Metric")
    public Metric getMetric() {
        return metric;
    }

    @JsonProperty("Metric")
    public void setMetric(Metric metric) {
        this.metric = metric;
    }
}
