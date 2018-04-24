package ru.example.testwork.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.example.testwork.dao.StatisticsRepository;
import ru.example.testwork.models.Links;
import ru.example.testwork.models.Statistics;

import java.util.Date;

@Service
public class StatService {

    @Autowired
    private StatisticsRepository statisticsRepository;

    public void addStat(Links link, String ip) {

        Statistics statistic = new Statistics();
        statistic.setLink(link);
        statistic.setIp(ip);
        statistic.setDate(new Date());

        statisticsRepository.save(statistic);

    }
}
