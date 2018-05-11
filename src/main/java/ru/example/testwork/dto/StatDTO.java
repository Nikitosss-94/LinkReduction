package ru.example.testwork.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Упрощенная модель данных, выдает ip и дату по ссылке
 */
public class StatDTO {

    String ip;

    String date;

    public StatDTO(String ip, Date date) {
        this.ip = ip;
        this.date = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(date);
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
