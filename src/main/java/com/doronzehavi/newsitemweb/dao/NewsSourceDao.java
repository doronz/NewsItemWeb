package com.doronzehavi.newsitemweb.dao;

import com.doronzehavi.newsitemweb.model.source.NewsSource;

import java.util.List;


public interface NewsSourceDao {
    public List<NewsSource> fetchAllNewsSources();

    public void save(NewsSource newsSource);

    public void saveAll(List<NewsSource> sources);

}