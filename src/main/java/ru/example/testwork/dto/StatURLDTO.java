package ru.example.testwork.dto;

import ru.example.testwork.models.Statistics;

import java.util.List;

/**
 *Упрощенная модель данных, выдает полную статистику выбранной сокращенной ссылки
 */
public class StatURLDTO {

    String realUrl;

    String url;

    List<Statistics> statistics;

    public StatURLDTO(String realUrl, String url, List<Statistics> statistics, Long id) {
        this.realUrl = realUrl;
        this.url = url.replace("/allstat", "/") + id;
        this.statistics = statistics;
    }

    public String getRealUrl() {
        return realUrl;
    }

    public void setRealUrl(String realUrl) {
        this.realUrl = realUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Statistics> getStatistics() {
        return statistics;
    }

    public void setStatistics(List<Statistics> statistics) {
        this.statistics = statistics;
    }
}
