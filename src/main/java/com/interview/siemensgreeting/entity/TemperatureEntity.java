package com.interview.siemensgreeting.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class TemperatureEntity {
    private String location;
    private Double tempC;
}
