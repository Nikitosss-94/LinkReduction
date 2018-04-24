package ru.example.testwork.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.example.testwork.dao.LinksRepository;
import ru.example.testwork.models.Links;

import java.util.List;

@Service
public class LinkService {

    @Autowired
    private LinksRepository linksRepository;

//    public String redirect(Long id) {
//        return linksRepository.findByUrl(id);
//    }

    public List<Links> getAll(){
        return linksRepository.findAll();
    }

    public Links getLink(Long id) {
//        linksRepository.findById(id);
        return linksRepository.findLinksById(id);
    }

}
