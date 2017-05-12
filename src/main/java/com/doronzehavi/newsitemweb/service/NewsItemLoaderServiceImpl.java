package com.doronzehavi.newsitemweb.service;


import com.doronzehavi.newsitemweb.dao.NewsSourceDao;
import com.doronzehavi.newsitemweb.model.item.NewsItem;
import com.doronzehavi.newsitemweb.model.item.NewsItemResponse;
import com.doronzehavi.newsitemweb.model.source.NewsSource;
import com.doronzehavi.newsitemweb.model.source.NewsSourceResponse;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

@Service
public class NewsItemLoaderServiceImpl implements NewsItemLoaderService {

    // TODO: Don't drop table, add new stories to it
    // TODO: Pull out of this class
    private static final String NEWSAPI_API_KEY = "0ca610c61a054ab58ab294304e556431";

    @Autowired
    private NewsSourceDao newsSourceDao;

    private final RestTemplate restTemplate;

    public NewsItemLoaderServiceImpl(RestTemplateBuilder restTemplateBuilder){
        this.restTemplate = restTemplateBuilder.build();
    }

    @Async
    @Scheduled(fixedDelay = 900000) // 15 minutes
    @SuppressWarnings("unchecked")
    public Future<List<NewsItem>> fetchAllNewsItemsFromApi(){
        List<NewsSource> sources = newsSourceDao.findAll();
        List<NewsItem> newsItems = new ArrayList<>();
        for (NewsSource source : sources) {
            String request = "https://newsapi.org/v1/articles?apikey=" + NEWSAPI_API_KEY + "&source=" + source.getId();
            ResponseEntity<NewsItemResponse> newsItemResponse =
                    restTemplate.exchange(request,
                            HttpMethod.GET, null, NewsItemResponse.class);
            NewsItemResponse response = newsItemResponse.getBody();
            List<NewsItem> itemsFromSource = response.getNewsItemList();
            for (NewsItem item : itemsFromSource){
                item.setNewsSource(source);
            }
            newsItems.addAll(itemsFromSource);
        }
        return new AsyncResult<>(newsItems);
    }
}
