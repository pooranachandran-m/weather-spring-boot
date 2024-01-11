package com.interview.siemensgreeting.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.interview.siemensgreeting.dto.Temperature;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.nio.file.Files.walk;

@Repository
@Slf4j
public class WeatherRepository {
    private final Map<String, Temperature> weatherDetails = new HashMap<>();

    public WeatherRepository() {
        // create Object Mapper
        ObjectMapper mapper = new ObjectMapper().findAndRegisterModules()
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        try {
            String dir = System.getProperty("user.dir") + "/src/main/resources/data/weather";
            List<Path> paths = walk(Paths.get(dir), 1) //by mentioning max depth as 1 it will only traverse immediate level
                    .filter(Files::isRegularFile)
                    .filter(path -> path.getFileName().toString().endsWith(".json")) // fetch only the files which are ending with .JSON
                    .toList();
            for (Path path : paths) {
                //read the Json File . change here according to your logic
                String json = new String(Files.readAllBytes(path));
                Temperature parsedTemperature = mapper.readValue(json, Temperature.class);
                weatherDetails.put(parsedTemperature.getLocation().getName().toLowerCase(), parsedTemperature);
                System.out.println(parsedTemperature);
            }
            System.out.println(weatherDetails.toString());
        } catch (Exception e) {
            log.error("Invalid Input Path defined. Unable to load Temperature Data",e);
        }
    }

    public Temperature getTemperature(String cityName) {
        if (weatherDetails.containsKey(cityName))
            return weatherDetails.get(cityName.toLowerCase());
        else
            throw new InvalidParameterException("Invalid location name");
    }

    public List<String> getCity() {
        return weatherDetails.values().stream().map(weather -> weather.getLocation().getName()).collect(Collectors.toList());
    }
}
