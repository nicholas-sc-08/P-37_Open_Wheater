package br.com.ow.Open.Wheater.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.ow.Open.Wheater.repository.WeatherRepo;

@Service
public class WeatherService {
    
    @Autowired
    private WeatherRepo weatherRepo;

    @Value("${openweather.api.key}")
    private String apiKey;

    public Object getByNameWeather(String name) {
        String url = "https://api.openweathermap.org/data/2.5/weather?q=" + name + "&appid=" + apiKey + "&units=metric&lang=pt-br";
        
        RestTemplate restTemplate = new RestTemplate();
        Object weather = restTemplate.getForObject(url, Object.class);
        
        return weather;
    } 
}
