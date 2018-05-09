package ru.example.testwork.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

/**
 *Модель таблицы Statistics базы LinksReductionDB
 */
@Component
@Entity
@Table(name = "statistics")
public class Statistics {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "stat_id", nullable = false)
    private Long id;

    @Column(name = "stat_date", nullable = false)
    @Temporal(value=TemporalType.TIMESTAMP)
    private Date date;

    @Column(name = "stat_ip", nullable = false)
    private String ip;

    @ManyToOne
    @JoinColumn(name = "link_id")
    private Links link;

    public Statistics() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Links getLink() {
        return link;
    }

    public void setLink(Links link) {
        this.link = link;
    }
}
