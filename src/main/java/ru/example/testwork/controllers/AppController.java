package ru.example.testwork.controllers;

import org.springframework.web.bind.annotation.*;
import ru.example.testwork.dto.AllURLDTO;
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
public class AppController {

    private LinkService linkService;

    private StatService statService;

    public AppController(LinkService linkService, StatService statService) {
        this.linkService = linkService;
        this.statService = statService;
    }

    @RequestMapping(value = "/{id}")
    public void realUrl (@PathVariable("id") Long id, HttpServletRequest request, HttpServletResponse response) throws IOException {

        Links link = linkService.getLink(id);
        if (link == null) {
            return;
        }
        statService.addStat(link, request.getRemoteAddr());
        response.sendRedirect(request.getScheme() + "://" + link.getUrl());
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String reduct(@RequestParam("url") String url, HttpServletRequest request) {
        Links link = linkService.getLink(url);
        if (link == null) {
            link = linkService.createLink(url);
        }
        String linkreduction = request.getRequestURL().toString();
        return linkreduction + link.getId();
    }

    @RequestMapping(value = "/stat={id}", method = RequestMethod.GET)
    public StatURLDTO stat(@PathVariable("id") Long id, HttpServletRequest request){
        Links link = linkService.getLink(id);
        StatURLDTO stat = new StatURLDTO(link.getUrl(),
                request.getRequestURL().toString(),
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
    public List<AllURLDTO> allstat(HttpServletRequest request){
        List<Links> links = linkService.getAll();
        return links.stream()
                .map(link -> {
                    AllURLDTO current = new AllURLDTO(link.getUrl(),
                            request.getRequestURL().toString(),
                            statService.lastStatDate(link),
                            link.getId());
                    return current;
                })
                .collect(Collectors.toList());
    }
}
