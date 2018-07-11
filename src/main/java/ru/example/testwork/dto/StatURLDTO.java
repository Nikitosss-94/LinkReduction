package ru.example.testwork.dto;

import ru.example.testwork.models.Statistics;

import java.util.List;

/**
 *Упрощенная модель данных, выдает полную статистику выбранной сокращенной ссылки
 */
public class StatURLDTO {

    String realUrl;

    Long id;

    List<StatDTO> statistics;

    public StatURLDTO(String realUrl, List<StatDTO> statistics, Long id) {
        this.realUrl = realUrl;
        this.id = id;
        this.statistics = statistics;
    }

    public String getRealUrl() {
        return realUrl;
    }

    public void setRealUrl(String realUrl) {
        this.realUrl = realUrl;
    }

    public Long getUrl() {
        return id;
    }

    public void setUrl(Long id) {
        this.id = id;
    }

    public List<StatDTO> getStatistics() {
        return statistics;
    }

    public void setStatistics(List<StatDTO> statistics) {
        this.statistics = statistics;
    }
}
