package br.com.ow.weather.dto;

import java.util.List;

import lombok.Data;

@Data
public class WeatherDTO {
    private String name;
    private MainData main;
    private List<WeatherDescription> weather;   
    private WindData wind;

    @Data 
    public static class MainData {
        private Double temp;
        private Double humidity;
    }

    @Data
    public static class WeatherDescription {
        private String main;
        private String description;
        private String icon;
    }

    @Data
    public static class WindData {
        private Double speed;
    }
}

