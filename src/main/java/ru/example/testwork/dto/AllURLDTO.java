package ru.example.testwork.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *Упрощенная модель данных, выдает краткую статистику всех сокращенных ссылок
 */
public class AllURLDTO {

    String realUrl;

    Long id;

    String lastDate;

    public AllURLDTO(String realUrl, String lastDate, Long id) {
        this.realUrl = realUrl;
        this.id = id;
        this.lastDate = lastDate;
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

    public String getLastDate() {
        return lastDate;
    }

    public void setLastDate(String lastDate) {
        this.lastDate = lastDate;
    }
}
