package br.com.ow.Open.Wheater.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.ow.Open.Wheater.service.WeatherService;

@RestController
public class WeatherController {
    
    @Autowired
    private WeatherService weatherService;

    @GetMapping("/weather/{name}")
    public Object getWeatherByName(@PathVariable String name) {
        return weatherService.getByNameWeather(name);
    }
}
