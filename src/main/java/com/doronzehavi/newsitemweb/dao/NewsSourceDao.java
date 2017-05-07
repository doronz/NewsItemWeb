package com.doronzehavi.newsitemweb.dao;

import com.doronzehavi.newsitemweb.model.source.NewsSource;

import java.util.List;


public interface NewsSourceDao {
    List<NewsSource> findAll();

    NewsSource save(NewsSource newsSource);

    void saveAll(List<NewsSource> sources);

}