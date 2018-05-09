package ru.example.testwork.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import ru.example.testwork.dto.AllURLDTO;
import ru.example.testwork.dto.StatURLDTO;
import ru.example.testwork.models.Links;
import ru.example.testwork.services.LinkService;
import ru.example.testwork.services.StatService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 *Класс, реализующий взаимодействие web-интерфейса с серверной частью.
 */
@RestController
public class AppController {

    private LinkService linkService;

    private StatService statService;

    @Autowired
    public AppController(LinkService linkService, StatService statService) {
        this.linkService = linkService;
        this.statService = statService;
    }

    @InitBinder()
    public void dateValidator(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
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

    @RequestMapping(value = "/stat", method = RequestMethod.GET)
    public StatURLDTO stat(@RequestParam("id") Long id, HttpServletRequest request){
        Links link = linkService.getLink(id);
        StatURLDTO stat = new StatURLDTO(link.getUrl(), request.getRequestURL().toString(), statService.filterStatistics(link), id);
//        stat.setRealUrl(link.getUrl());
//        stat.setUrl(request.getRequestURL().toString().replace("/allstat", "/") + id);
//        stat.setStatistics(statService.filterStatistics(link));
        return stat;
    }

    @RequestMapping(value = "/allstat", method = RequestMethod.GET)
    public List<AllURLDTO> allstat(HttpServletRequest request){
        List<Links> links = linkService.getAll();
//        List<AllURLDTO> allURLDTOList = links.stream()
//                .map(link -> {
//                    AllURLDTO current = new AllURLDTO(link.getUrl(),
//                            request.getRequestURL().toString(),
//                            statService.lastStatDate(link),
//                            link.getId());
//                    return current;
//                })
//                .collect(Collectors.toList());
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
