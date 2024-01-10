package com.interview.siemensgreeting.service;

import com.interview.siemensgreeting.dto.Temperature;

import java.util.List;

public interface WeatherService {

    public Temperature getWeather(String city);

    public List<String> getCity();
}
