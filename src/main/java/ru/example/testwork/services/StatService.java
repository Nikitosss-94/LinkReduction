package ru.example.testwork.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.example.testwork.dao.StatisticsRepository;
import ru.example.testwork.models.Links;
import ru.example.testwork.models.Statistics;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 *Класс, преобразующий данные с контроллера в данные, совместимые с данными базы данных
 */
@Service
public class StatService {

    private StatisticsRepository statisticsRepository;

    public StatService(StatisticsRepository statisticsRepository)
    {
        this.statisticsRepository = statisticsRepository;
    }

    public void addStat(Links link, String ip) {

        Statistics statistic = new Statistics();
        statistic.setLink(link);
        statistic.setIp(ip);
        statistic.setDate(new Date());

        statisticsRepository.save(statistic);

    }

    public List<Statistics> filterStatistics(Links link){
        return statisticsRepository.findStatisticsByLink(link);
    }

    public String lastStatDate(Links link) {
        List<Statistics> list = statisticsRepository.findStatisticsByLink(link);
        Statistics statistic = list.size() == 0 ? null : list.stream().max(Comparator.comparing(Statistics::getDate)).get();
        return statistic == null ? "Не использовался" : new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(statistic.getDate());
    }
}
