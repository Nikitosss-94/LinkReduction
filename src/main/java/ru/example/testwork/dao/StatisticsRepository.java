package ru.example.testwork.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.example.testwork.models.Statistics;

@Repository
public interface StatisticsRepository extends JpaRepository<Statistics, Long> {
}
