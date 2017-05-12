package com.doronzehavi.newsitemweb.service;


import com.doronzehavi.newsitemweb.dao.item.NewsItemDao;
import com.doronzehavi.newsitemweb.model.item.NewsItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class NewsItemServiceImpl implements NewsItemService {

    @Autowired
    private NewsItemDao newsItemDao;

    public Page<NewsItem> fetchNewsItemsByPage(int pageNumber){
        return newsItemDao.fetchNewsItemsByPage(pageNumber);
    }
}
