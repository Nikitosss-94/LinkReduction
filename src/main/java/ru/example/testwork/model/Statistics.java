package ru.example.testwork.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "Statistics")
public class Statistics {

    private Long id;

    private Date date;

    private String ip;

    private Links link;

    public Statistics() {
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "stat_id", unique = true, nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "stat_date", nullable = false)
    @Temporal(value=TemporalType.TIMESTAMP)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Column(name = "stat_ip", nullable = false)
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "links_id", referencedColumnName = "links_id")
    @JsonBackReference
    public Links getLink() {
        return link;
    }

    public void setLink(Links link) {
        this.link = link;
    }
}
