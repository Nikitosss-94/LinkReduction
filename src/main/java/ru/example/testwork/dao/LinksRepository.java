package ru.example.testwork.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.example.testwork.model.Links;

public interface LinksRepository extends JpaRepository<Links, Long> {
}
