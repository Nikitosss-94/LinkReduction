package ru.example.testwork.services;

import org.springframework.beans.factory.annotation.Autowired;
import ru.example.testwork.dao.LinksRepository;

public class LinkService {

    @Autowired
    private LinksRepository linksRepository;

    public String redirect(Long id) {
        return linksRepository.findByUrl(id);
    }


}
