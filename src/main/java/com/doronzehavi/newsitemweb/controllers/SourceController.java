package com.doronzehavi.newsitemweb.controllers;

import com.doronzehavi.newsitemweb.model.item.NewsItem;
import com.doronzehavi.newsitemweb.model.source.NewsSource;
import com.doronzehavi.newsitemweb.service.NewsSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class SourceController {
    @Autowired
    private NewsSourceService newsSourceService;

    @RequestMapping(value = "/sources")
    public String listNewsItems(Model model) {

        List<NewsSource> sourcesList = newsSourceService.fetchAllNewsSources();

        model.addAttribute("sourceList", sourcesList);
        return "sources";
    }
}
