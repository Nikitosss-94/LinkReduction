package ru.example.testwork.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.example.testwork.models.Links;

public interface LinksRepository extends JpaRepository<Links, Long> {

    String findByUrl(Long id);
}
