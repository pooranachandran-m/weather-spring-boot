package com.interview.siemensgreeting.controller;

import com.interview.siemensgreeting.dto.Temperature;
import com.interview.siemensgreeting.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GreetingsController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/api/{name}")
    public ResponseEntity<String> greetUser(@PathVariable String name){
        return ResponseEntity.ok("Hello "+name);
    }

    @GetMapping("/weather/city/{cityName}")
    public ResponseEntity<Temperature> getTemperatureForCity(@PathVariable String cityName){
        return ResponseEntity.ok(weatherService.getWeather(cityName));
    }

    @GetMapping("/weather/location")
    public ResponseEntity<List<String>> getCity(){
        return ResponseEntity.ok(weatherService.getCity());
    }

}
