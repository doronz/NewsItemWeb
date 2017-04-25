package com.doronzehavi.newsitemweb.controllers;

import com.doronzehavi.newsitemweb.model.item.NewsItem;
import com.doronzehavi.newsitemweb.service.NewsItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class FeedController {

    @Autowired
    private NewsItemService newsItemService;

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/feed")
    public String listNewsItems(Model model) {

        List<NewsItem> newsFeedList = newsItemService.fetchAllNewsItems();

        model.addAttribute("newsfeed", newsFeedList);
        return "feed";
    }


}
