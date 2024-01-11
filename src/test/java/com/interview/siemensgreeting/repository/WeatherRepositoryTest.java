package com.interview.siemensgreeting.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WeatherRepositoryTest {

    private final static String VALID_CITY="Bangalore";
    private final static String INVALID_CITY="invalid-city";

    private WeatherRepository weatherRepository;

    @BeforeEach
    void setUp() {
        weatherRepository = new WeatherRepository();
    }
    @Test
    @DisplayName("Invalid JSON location path")
    void WeatherRepositoryInstantiationInvalidPath() {
        System.setProperty("user.dir", "invalid-path");
        weatherRepository = new WeatherRepository();
        assertEquals(0 ,weatherRepository.getCity().size());
    }
    @Test
    @DisplayName("Get Temperature in Celsius for a Valid City")
    void getTemperatureForValidCity() {
        var weather=weatherRepository.getTemperature(VALID_CITY.toLowerCase());
        assertEquals(VALID_CITY,weather.getLocation().getName());
        assertNotNull(weather.getCurrent().getTempC());
    }

    @Test
    @DisplayName("Get Temperature for a Invalid City Throws InvalidParameterException")
    void getTemperatureForInvalidCity() {
        InvalidParameterException thrown = assertThrows(
                InvalidParameterException.class,
                () -> weatherRepository.getTemperature(INVALID_CITY.toLowerCase()),
                "Expected getTemperature() to throw InvalidParameterException, but it didn't"
        );

        assertTrue(thrown.getMessage().contains("Invalid location name"));
    }

    @Test
    @DisplayName("Get City returns List of available cities")
    void getCityReturnsListOfAvailableCity() {
        List<String> cities=weatherRepository.getCity();
        assertEquals(6,cities.size());
    }
}