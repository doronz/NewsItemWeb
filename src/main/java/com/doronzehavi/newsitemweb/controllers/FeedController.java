package com.doronzehavi.newsitemweb.controllers;

import com.doronzehavi.newsitemweb.model.item.NewsItem;
import com.doronzehavi.newsitemweb.service.NewsItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class FeedController {

    @Autowired
    private NewsItemService newsItemService;

    @RequestMapping(value = "/feed")
    public String showFeed(Model model) {
        Page<NewsItem> page = newsItemService.fetchNewsItemsByPage(1);
        model.addAttribute("newsfeed", page.getContent());
        int current = page.getNumber();
        int next = current + 1;
        int last = page.getTotalPages() - 1;

        model.addAttribute("current", current);
        model.addAttribute("next", next);
        model.addAttribute("last", last);
        return "feed";
    }

    @RequestMapping(value = "/feed/{pageNumber}", method = RequestMethod.GET)
    public String showFeedByPage(@PathVariable Integer pageNumber, Model model) {
        Page<NewsItem> page = newsItemService.fetchNewsItemsByPage(pageNumber);
        int current = page.getNumber();
        int next = current + 1;
        int prev = current - 1;
        int last = page.getTotalPages() - 1;

        model.addAttribute("current", current);
        model.addAttribute("next", next);
        model.addAttribute("prev", prev);
        model.addAttribute("last", last);

        return "feed";
    }
}