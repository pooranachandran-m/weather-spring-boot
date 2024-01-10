package com.interview.siemensgreeting.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.interview.siemensgreeting.dto.Current;
import com.interview.siemensgreeting.dto.Location;
import com.interview.siemensgreeting.dto.Temperature;
import com.interview.siemensgreeting.entity.TemperatureEntity;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidParameterException;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class WeatherRepository {
    Map<String,Temperature> weatherDetails= new HashMap<>();


    public WeatherRepository(){
        // create Object Mapper
        ObjectMapper mapper = new ObjectMapper().findAndRegisterModules()
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);;
        String dir =System.getProperty("user.dir")+"/src/main/resources/data/weather";

        try{
            List<Path> paths = Files.walk(Paths.get(dir),1) //by mentioning max depth as 1 it will only traverse immediate level
                    .filter(Files::isRegularFile)
                    .filter(path-> path.getFileName().toString().endsWith(".json")) // fetch only the files which are ending with .JSON
                    .collect(Collectors.toList());
            //iterate all the paths and fetch data from corresnponding file
            for(Path path : paths) {
                //read the Json File . change here according to your logic
                String json = new String(Files.readAllBytes(path));
                Temperature parsedTemperature = mapper.readValue(json, Temperature.class);
                weatherDetails.put(parsedTemperature.getLocation().getName().toLowerCase(),parsedTemperature);
                System.out.println(parsedTemperature);
            }
            System.out.println(weatherDetails.toString());
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Temperature getTemperature(String cityName){
        if(weatherDetails.containsKey(cityName))
            return weatherDetails.get(cityName.toLowerCase());
        else
            throw new InvalidParameterException("Invalid location name");
    }

    public List<String> getCity(){
        return weatherDetails.values().stream().map( weather -> weather.getLocation().getName()).collect(Collectors.toList());
    }
}
