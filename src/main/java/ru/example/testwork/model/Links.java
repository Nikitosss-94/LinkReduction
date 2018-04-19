package ru.example.testwork.model;

import javax.persistence.*;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "Links")
public class Links {

    private Long id;

    private String RealURL;

    private String URL;

    private Set<Statistics> statistics;

    public Links() {
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "links_id", unique = true, nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "links_realurl", nullable = false)
    public String getRealURL() {
        return RealURL;
    }

    public void setRealURL(String realURL) {
        RealURL = realURL;
    }

    @Column(name = "links_url", nullable = false)
    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "Links", targetEntity = Statistics.class, cascade = CascadeType.ALL)
    public Set<Statistics> getStatistics() {
        return statistics;
    }

    public void setStatistics(Set<Statistics> statistics) {
        this.statistics = statistics;
    }
}
