package ru.example.testwork.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.example.testwork.services.LinkService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AppController {

    @Autowired
    private LinkService linkService;

    @RequestMapping("/{id}")
    public String realUrl (@PathVariable("id") Long id, HttpServletRequest request) {
        return "redirect:" + request.getScheme() + "://" + linkService.redirect(id);
    }
}
