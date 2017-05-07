package com.doronzehavi.newsitemweb.service;

import com.doronzehavi.newsitemweb.model.item.NewsItem;
import com.doronzehavi.newsitemweb.model.source.NewsSource;

import java.util.List;


public interface NewsSourceService {
    public List<NewsSource> findAll();

    public void save(NewsSource newsSource);
}
