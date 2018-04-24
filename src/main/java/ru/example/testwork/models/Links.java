package ru.example.testwork.models;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Component
@Entity
@Table(name = "links")
public class Links {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "link_id", nullable = false)
    private Long id;

    @Column(name = "link_url", nullable = false)
    private String URL;

    public Links() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

//    private Set<Statistics> statistics;
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "Links", targetEntity = Statistics.class, cascade = CascadeType.ALL)
//    public Set<Statistics> getStatistics() {
//        return statistics;
//    }
//
//    public void setStatistics(Set<Statistics> statistics) {
//        this.statistics = statistics;
//    }
}
