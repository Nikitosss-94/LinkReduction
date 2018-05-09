package ru.example.testwork.models;

import org.springframework.stereotype.Component;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 *Модель таблицы Links базы LinksReductionDB
 */
@Component
@Entity
@Table(name = "links")
public class Links {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "link_id", nullable = false)
    private Long id;

    @Column(name = "link_url", nullable = false)
    private String url;

    public Links() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
