package com.doronzehavi.newsitemweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class MainController {

    @RequestMapping(value = "/")
    public RedirectView straighToFeed(){
        return new RedirectView("feed");
    }
}
