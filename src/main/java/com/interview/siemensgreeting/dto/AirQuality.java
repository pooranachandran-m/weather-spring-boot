
package com.interview.siemensgreeting.dto;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "co",
    "no2",
    "o3",
    "so2",
    "pm2_5",
    "pm10",
    "us-epa-index",
    "gb-defra-index"
})
@Data
public class AirQuality {

    @JsonProperty("co")
    private Double co;
    @JsonProperty("no2")
    private Double no2;
    @JsonProperty("o3")
    private Double o3;
    @JsonProperty("so2")
    private Double so2;
    @JsonProperty("pm2_5")
    private Double pm25;
    @JsonProperty("pm10")
    private Double pm10;
    @JsonProperty("us-epa-index")
    private Integer usEpaIndex;
    @JsonProperty("gb-defra-index")
    private Integer gbDefraIndex;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("co")
    public Double getCo() {
        return co;
    }

    @JsonProperty("co")
    public void setCo(Double co) {
        this.co = co;
    }

    public AirQuality withCo(Double co) {
        this.co = co;
        return this;
    }

    @JsonProperty("no2")
    public Double getNo2() {
        return no2;
    }

    @JsonProperty("no2")
    public void setNo2(Double no2) {
        this.no2 = no2;
    }

    public AirQuality withNo2(Double no2) {
        this.no2 = no2;
        return this;
    }

    @JsonProperty("o3")
    public Double getO3() {
        return o3;
    }

    @JsonProperty("o3")
    public void setO3(Double o3) {
        this.o3 = o3;
    }

    public AirQuality withO3(Double o3) {
        this.o3 = o3;
        return this;
    }

    @JsonProperty("so2")
    public Double getSo2() {
        return so2;
    }

    @JsonProperty("so2")
    public void setSo2(Double so2) {
        this.so2 = so2;
    }

    public AirQuality withSo2(Double so2) {
        this.so2 = so2;
        return this;
    }

    @JsonProperty("pm2_5")
    public Double getPm25() {
        return pm25;
    }

    @JsonProperty("pm2_5")
    public void setPm25(Double pm25) {
        this.pm25 = pm25;
    }

    public AirQuality withPm25(Double pm25) {
        this.pm25 = pm25;
        return this;
    }

    @JsonProperty("pm10")
    public Double getPm10() {
        return pm10;
    }

    @JsonProperty("pm10")
    public void setPm10(Double pm10) {
        this.pm10 = pm10;
    }

    public AirQuality withPm10(Double pm10) {
        this.pm10 = pm10;
        return this;
    }

    @JsonProperty("us-epa-index")
    public Integer getUsEpaIndex() {
        return usEpaIndex;
    }

    @JsonProperty("us-epa-index")
    public void setUsEpaIndex(Integer usEpaIndex) {
        this.usEpaIndex = usEpaIndex;
    }

    public AirQuality withUsEpaIndex(Integer usEpaIndex) {
        this.usEpaIndex = usEpaIndex;
        return this;
    }

    @JsonProperty("gb-defra-index")
    public Integer getGbDefraIndex() {
        return gbDefraIndex;
    }

    @JsonProperty("gb-defra-index")
    public void setGbDefraIndex(Integer gbDefraIndex) {
        this.gbDefraIndex = gbDefraIndex;
    }

    public AirQuality withGbDefraIndex(Integer gbDefraIndex) {
        this.gbDefraIndex = gbDefraIndex;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public AirQuality withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
