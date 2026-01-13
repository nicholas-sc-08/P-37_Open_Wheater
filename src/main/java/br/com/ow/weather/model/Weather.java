package br.com.ow.weather.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Table(name = "tbl_weather") 
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Weather {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "main", nullable = false)
    private String main;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "icon", nullable = false)
    private String icon;

    @Column(name = "temp", nullable = false)
    private Double temp;

    @Column(name = "humidity", nullable = false)
    private Double humidity;

    @Column(name = "wind_speed", nullable = false)
    private Double windSpeed;
}
