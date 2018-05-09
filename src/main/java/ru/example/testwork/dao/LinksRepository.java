package ru.example.testwork.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.example.testwork.models.Links;

/**
 *Класс, выполняющий операции с данными таблицы Links в LinksReductionDB
 */
@Repository
public interface LinksRepository extends JpaRepository<Links, Long> {

    Links findLinksById(Long id);

    Links findLinksByUrl(String url);


}

