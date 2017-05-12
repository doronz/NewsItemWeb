package com.doronzehavi.newsitemweb.service;


import com.doronzehavi.newsitemweb.dao.source.NewsSourceDao;
import com.doronzehavi.newsitemweb.model.source.NewsSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
