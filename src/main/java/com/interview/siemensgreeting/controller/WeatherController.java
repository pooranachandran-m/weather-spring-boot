package com.interview.siemensgreeting.controller;

import com.interview.siemensgreeting.dto.Temperature;
import com.interview.siemensgreeting.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * API's related Weather such as Humidity, Air Quality and Temperature.
 *
 * @author Pooranachandran Muthusamy
 * @since 10 Jan 2024
 */
@RestController
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    /**
     * Returns Weather information for the provided city
     * @param cityName city for which weather information has to be retrieved
     * @return Weather information
     */
    @GetMapping("/weather/city/{cityName}")
    public ResponseEntity<Temperature> getTemperatureForCity(@PathVariable String cityName){
        return ResponseEntity.ok(weatherService.getWeather(cityName));
    }

    /**
     * Returns list of cities for which weather data is available
     * @return List of Cities
     */
    @GetMapping("/weather/location")
    public ResponseEntity<List<String>> getCity(){
        return ResponseEntity.ok(weatherService.getCity());
    }

}
