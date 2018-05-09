package ru.example.testwork.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.example.testwork.models.Links;
import ru.example.testwork.models.Statistics;
import java.util.List;

/**
 *Класс, выполняющий операции с данными таблицы Statistics в LinksReductionDB
 */
@Repository
public interface StatisticsRepository extends JpaRepository<Statistics, Long> {

    //    @Query("select s " +
//           "from Statistics s " +
//           "where s.link")
    List<Statistics> findStatisticsByLink(Links link);
}
