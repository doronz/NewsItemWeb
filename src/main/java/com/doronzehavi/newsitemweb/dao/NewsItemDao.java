package com.doronzehavi.newsitemweb.dao;

import com.doronzehavi.newsitemweb.model.item.NewsItem;
import org.springframework.data.domain.Page;

import java.util.List;

public interface NewsItemDao {
    public List<NewsItem> fetchAllNewsItems();
    public void saveAll(List<NewsItem> newsItems);
    public void save(NewsItem newsItem);
    public Page<NewsItem> fetchNewsItemsByPage(int pageNumber);
}
