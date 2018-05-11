package ru.example.testwork.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.example.testwork.dao.LinksRepository;
import ru.example.testwork.models.Links;

import java.util.List;

/**
 *Класс, преобразующий данные с контроллера в данные, совместимые с данными базы данных
 */
@Service
public class LinkService {

    private LinksRepository linksRepository;

    public LinkService(LinksRepository linksRepository) {
        this.linksRepository = linksRepository;
    }

    public List<Links> getAll(){
        return linksRepository.findAll();
    }

    public Links getLink(Long id) {
        return linksRepository.findLinksById(id);
    }

    public Links getLink(String url){
        return linksRepository.findLinksByUrl(url);
    }

    public Links createLink(String url){
        Links link = new Links();
        link.setUrl(url);
        linksRepository.save(link);
        return link;
    }

}
