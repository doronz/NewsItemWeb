package com.doronzehavi.newsitemweb.controllers;

import com.doronzehavi.newsitemweb.model.item.NewsItem;
import com.doronzehavi.newsitemweb.model.source.NewsSource;
import com.doronzehavi.newsitemweb.service.NewsItemService;
import com.doronzehavi.newsitemweb.service.NewsSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class FeedController {

    @Autowired
    private NewsItemService newsItemService;

    @Autowired
    private NewsSourceService newsSourceService;

    @RequestMapping(value = {"/feed", "/feed/0"})
    public String showFeed(Model model) {
        Page<NewsItem> page = newsItemService.fetchNewsItemsByPage(1);
        int current = page.getNumber() + 1;
        int next = current + 1;
        int last = page.getTotalPages();

        model.addAttribute("sourceMap", getMapOfNewsSourcesById());
        model.addAttribute("newsfeed", page.getContent());
        model.addAttribute("current", current);
        model.addAttribute("next", next);
        model.addAttribute("prev", null);
        model.addAttribute("last", last);
        return "feed";
    }

    @RequestMapping(value = "/feed/{pageNumber}")
    public String showFeedByPage(@PathVariable Integer pageNumber, Model model) {
        Page<NewsItem> page = newsItemService.fetchNewsItemsByPage(pageNumber);
        int current = pageNumber;
        int next = current + 1;
        int prev = current - 1;
        int last = page.getTotalPages() - 1;

        model.addAttribute("newsfeed", page.getContent());
        model.addAttribute("current", current);
        model.addAttribute("next", next <= last ? next : null);
        model.addAttribute("prev", prev >= 0 ? prev : null);
        model.addAttribute("last", last);

        return "feed";
    }

    private Map<String, String> getMapOfNewsSourcesById(){
        HashMap<String, String> map = new HashMap<>();
        for (NewsSource source: newsSourceService.findAll()){
            map.put(source.getId(), source.getName());
        }
        return map;
    }
}