package ru.example.testwork.controllers;

import org.springframework.web.bind.annotation.*;
import ru.example.testwork.dto.AllURLDTO;
import ru.example.testwork.dto.RedirectDTO;
import ru.example.testwork.dto.StatDTO;
import ru.example.testwork.dto.StatURLDTO;
import ru.example.testwork.models.Links;
import ru.example.testwork.services.LinkService;
import ru.example.testwork.services.StatService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 *Класс, реализующий взаимодействие web-интерфейса с серверной частью.
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class AppController {

    private LinkService linkService;

    private StatService statService;

    public AppController(LinkService linkService, StatService statService) {
        this.linkService = linkService;
        this.statService = statService;
    }

    @RequestMapping(value = "/{id}")
    public RedirectDTO realUrl (@PathVariable("id") Long id, HttpServletRequest request, HttpServletResponse response) throws IOException {

        Links link = linkService.getLink(id);
        RedirectDTO redirectDTO = new RedirectDTO();
        if (link != null) {
            statService.addStat(link, request.getRemoteAddr());
            redirectDTO.setUrl(request.getScheme() + "://" + link.getUrl());
        }
        return redirectDTO;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Links reduct(@RequestParam("url") String url, HttpServletRequest request) {
        Links link = linkService.getLink(url);
        if (link == null) {
            link = linkService.createLink(url);
        }
        return link;
    }

    @RequestMapping(value = "/stat={id}", method = RequestMethod.GET)
    public StatURLDTO stat(@PathVariable("id") Long id){
        Links link = linkService.getLink(id);
        StatURLDTO stat = new StatURLDTO(link.getUrl(),
                statService.filterStatistics(link).stream()
                        .map(st -> {
                            StatDTO cur = new StatDTO(st.getIp(), st.getDate());
                            return cur;
                        })
                        .collect(Collectors.toList()),
                id);
        return stat;
    }

    @RequestMapping(value = "/allstat", method = RequestMethod.GET)
    public List<AllURLDTO> allstat(){
        List<Links> links = linkService.getAll();
        List<AllURLDTO> allstat = links.stream()
                .map(l -> {
                    AllURLDTO current = new AllURLDTO(l.getUrl(),
                            statService.lastStatDate(l),
                            l.getId());
                    return current;
                })
                .collect(Collectors.toList());
        return allstat;
    }
}
