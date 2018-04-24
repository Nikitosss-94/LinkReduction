package ru.example.testwork.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.example.testwork.models.Links;

@Repository
public interface LinksRepository extends JpaRepository<Links, Long> {

    Links findLinksById(Long id);
}

