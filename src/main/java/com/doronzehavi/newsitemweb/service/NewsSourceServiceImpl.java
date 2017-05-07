package com.doronzehavi.newsitemweb.service;


import com.doronzehavi.newsitemweb.dao.NewsItemDao;
import com.doronzehavi.newsitemweb.dao.NewsSourceDao;
import com.doronzehavi.newsitemweb.model.source.NewsSource;
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
public class NewsSourceServiceImpl implements NewsSourceService {

    @Autowired
    private NewsSourceDao newsSourceDao;

    @Override
    public List<NewsSource> findAll() {
        return newsSourceDao.findAll();
    }

    @Override
    public void save(NewsSource newsSource) {
        newsSourceDao.save(newsSource);
    }


}
