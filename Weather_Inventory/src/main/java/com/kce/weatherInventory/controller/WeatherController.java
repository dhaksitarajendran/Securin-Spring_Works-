package com.kce.weatherInventory.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import com.kce.weatherInventory.entity.Weather;
import com.kce.weatherInventory.service.WeatherService;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherservice;

    @PostMapping("/upload")
    public ResponseEntity<?> upload_products(
            @RequestParam("file") MultipartFile file) throws Exception {

        return ResponseEntity.ok(weatherservice.uploadProducts(file));
    }
    @GetMapping("/get_by_month/{month}")
    public ResponseEntity<List<Weather>> get_by_month(
            @PathVariable int month) {

        return ResponseEntity.ok(
                weatherservice.getWeatherByMonth(month));
    }
    @GetMapping("/get_by_date/{date}")
    public ResponseEntity<List<Weather>> get_by_date(
            @PathVariable String date) {

        return ResponseEntity.ok(
                weatherservice.getWeatherByDate(
                        LocalDate.parse(date)));
    }
    @GetMapping("/min_temp/{year}/{month}")
    public ResponseEntity<Double> min_temp(
            @PathVariable int year,
            @PathVariable int month) {

        return ResponseEntity.ok(
                weatherservice.getMinTempForMonth(year, month));
    }

    @GetMapping("/max_temp/{year}/{month}")
    public ResponseEntity<Double> max_temp(
            @PathVariable int year,
            @PathVariable int month) {

        return ResponseEntity.ok(
                weatherservice.getMaxTempForMonth(year, month));
    }
    @GetMapping("/median_temp/{year}/{month}")
    public ResponseEntity<Double> median_temp(
            @PathVariable int year,
            @PathVariable int month) {

        return ResponseEntity.ok(
                weatherservice.getMedianTempForMonth(year, month));
    }
}