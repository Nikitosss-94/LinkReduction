package ru.example.testwork.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *Упрощенная модель данных, выдает краткую статистику всех сокращенных ссылок
 */
public class AllURLDTO {

    String realUrl;

    String url;

    String lastDate;

    public AllURLDTO(String realUrl, String url, Date lastDate, Long id) {
        this.realUrl = realUrl;
        this.url = url.replace("/allstat", "/") + id;
        this.lastDate = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(lastDate);
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

    public String getLastDate() {
        return lastDate;
    }

    public void setLastDate(String lastDate) {
        this.lastDate = lastDate;
    }
}
