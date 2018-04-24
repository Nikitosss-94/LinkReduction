package ru.example.testwork.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.example.testwork.models.Links;
import ru.example.testwork.models.Statistics;
import ru.example.testwork.services.LinkService;
import ru.example.testwork.services.StatService;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Date;
import java.util.Locale;

@Controller
public class AppController {

    @Autowired
    private LinkService linkService;

    @Autowired
    private StatService statService;

    @InitBinder()
    public void dateValidator(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @RequestMapping(value = "/{id}")
    public String realUrl (@PathVariable("id") Long id, HttpServletRequest request, Model model) {

        Links link = linkService.getLink(id);
        if (link == null) {
            return null;
        }
        statService.addStat(link, request.getRemoteAddr());
        return "redirect:" + request.getScheme() + "://" + link.getURL();
    }
}
