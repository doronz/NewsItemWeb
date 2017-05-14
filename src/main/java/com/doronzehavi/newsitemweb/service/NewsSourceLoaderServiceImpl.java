package com.doronzehavi.newsitemweb.service;

import com.doronzehavi.newsitemweb.model.source.NewsSource;
import com.doronzehavi.newsitemweb.model.source.NewsSourceResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.Future;

@Service
public class NewsSourceLoaderServiceImpl implements NewsSourceLoaderService {

    private final RestTemplate restTemplate;

    public NewsSourceLoaderServiceImpl(RestTemplateBuilder restTemplateBuilder){
        this.restTemplate = restTemplateBuilder.build();
    }

    // TODO: Eventually run this only if it hasn't been run recently
    // TODO: Fix naming of local variables here

    @Async
    public Future<List<NewsSource>> fetchAllNewsSourcesFromApi(){

        String request = "https://newsapi.org/v1/sources?language=en&country=us";
        ResponseEntity<NewsSourceResponse> newsSourcesResponse =
                restTemplate.exchange(request,
                        HttpMethod.GET, null, NewsSourceResponse.class);
        NewsSourceResponse response = newsSourcesResponse.getBody();
        List<NewsSource> newsSources = response.getSourceList();
        return new AsyncResult<>(newsSources);
    }

}
