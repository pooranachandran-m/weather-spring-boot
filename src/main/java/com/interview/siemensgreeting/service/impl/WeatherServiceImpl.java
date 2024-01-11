package com.interview.siemensgreeting.service.impl;

import com.interview.siemensgreeting.dto.Temperature;
import com.interview.siemensgreeting.repository.WeatherRepository;
import com.interview.siemensgreeting.service.WeatherService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Provides option to get location details and weather specific information
 *
 * @author Pooranachandran Muthusamy
 */
@Service
public class WeatherServiceImpl implements WeatherService {

    private final WeatherRepository weatherRepository;

    public WeatherServiceImpl(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    @Override
    public Temperature getWeather(String city) {
        return weatherRepository.getTemperature(city.toLowerCase());
    }

    @Override
    public List<String> getCity() {
        return weatherRepository.getCity();
    }
}
