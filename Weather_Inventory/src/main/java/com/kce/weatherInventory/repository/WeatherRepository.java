package com.kce.weatherInventory.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kce.weatherInventory.entity.Weather;

public interface WeatherRepository extends JpaRepository<Weather, Long> {

    List<Weather> findByCondi(String condi, Sort sort);

    List<Weather> findByTempBetween(Double min, Double max, Sort sort);

    List<Weather> findByCondiAndTempBetween(
            String condi, Double min, Double max, Sort sort);

    List<Weather> findByDateTime(LocalDate dateTime);

    @Query("SELECT w FROM Weather w WHERE MONTH(w.dateTime) = :month")
    List<Weather> findByMonth(@Param("month") int month);

    @Query("SELECT MIN(w.temp) FROM Weather w " +
           "WHERE YEAR(w.dateTime) = :year AND MONTH(w.dateTime) = :month")
    Double findMinTemp(@Param("year") int year,
                       @Param("month") int month);

    // ✅ max temp
    @Query("SELECT MAX(w.temp) FROM Weather w " +
           "WHERE YEAR(w.dateTime) = :year AND MONTH(w.dateTime) = :month")
    Double findMaxTemp(@Param("year") int year,
                       @Param("month") int month);
}