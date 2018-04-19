package ru.example.testwork.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.example.testwork.model.Statistics;

public interface StatisticsRepository extends JpaRepository<Statistics, Long> {
}
