package ru.example.testwork.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.example.testwork.models.Statistics;

public interface StatisticsRepository extends JpaRepository<Statistics, Long> {
}
