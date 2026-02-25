package com.kce.weatherInventory.service;

import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kce.weatherInventory.entity.Weather;
import com.kce.weatherInventory.repository.WeatherRepository;
import com.opencsv.CSVReader;

@Service
public class WeatherService {

    @Autowired
    private WeatherRepository weatherrepo;

    public String uploadProducts(MultipartFile file) throws Exception {

        if (!file.getOriginalFilename().endsWith(".csv")) {
            throw new RuntimeException("Only CSV files are allowed!");
        }

        List<Weather> weatherList = new ArrayList<>();

        try (CSVReader reader =
                new CSVReader(new InputStreamReader(file.getInputStream()))) {

            List<String[]> rows = reader.readAll();

            for (int i = 1; i < rows.size(); i++) {

                String[] row = rows.get(i);

                Weather weather = new Weather();

                weather.setDateTime(LocalDate.parse(row[0]));
                weather.setTemp(Double.parseDouble(row[1]));
                weather.setHumi(Double.parseDouble(row[2]));
                weather.setPressure(Double.parseDouble(row[3]));
                weather.setCondi(row[4]);
                weather.setHeatindex(Double.parseDouble(row[5]));

                weatherList.add(weather);
            }

            weatherrepo.saveAll(weatherList);
        }

        return "WeatherRecords uploaded successfully. Records inserted: " + weatherList.size();
    }

    public List<Weather> getWeatherByMonth(int month) {
        return weatherrepo.findByMonth(month);
    }

    public List<Weather> getWeatherByDate(LocalDate date) {
    	return weatherrepo.findByDateTime(date);
    }

    public Double getMinTempForMonth(int year, int month) {
        return weatherrepo.findMinTemp(year, month);
    }

    public Double getMaxTempForMonth(int year, int month) {
        return weatherrepo.findMaxTemp(year, month);
    }


    public List<Weather> sortByTemp(String order) {
        if (order.equalsIgnoreCase("desc")) {
            return weatherrepo.findAll(Sort.by("temp").descending());
        }
        return weatherrepo.findAll(Sort.by("temp").ascending());
    }

    public List<Weather> sortHumiByMonth(int month, String order) {

        List<Weather> list = weatherrepo.findByMonth(month);

        if (order.equalsIgnoreCase("desc")) {
            list.sort(Comparator.comparing(Weather::getHumi).reversed());
        } else {
            list.sort(Comparator.comparing(Weather::getHumi));
        }

        return list;
    }
    public Double getMedianTempForMonth(int year, int month) {

        List<Weather> list = weatherrepo.findByMonth(month);
        List<Double> temps = new ArrayList<>();

        for (Weather w : list) {
            if (w.getDateTime().getYear() == year) {
                temps.add(w.getTemp());
            }
        }

        if (temps.isEmpty()) {
            return null;
        }

        temps.sort(null);

        int size = temps.size();

        if (size % 2 == 0) {
            return (temps.get(size/2 - 1) + temps.get(size/2)) / 2;
        } else {
            return temps.get(size/2);
        }
    }
}