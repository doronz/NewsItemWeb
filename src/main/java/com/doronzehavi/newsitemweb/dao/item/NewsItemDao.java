package com.doronzehavi.newsitemweb.dao.item;

import com.doronzehavi.newsitemweb.model.item.NewsItem;
import org.springframework.data.domain.Page;

import java.util.List;

public interface NewsItemDao {
    public void saveAll(List<NewsItem> newsItems);
    public NewsItem save(NewsItem newsItem);
    public Page<NewsItem> fetchNewsItemsByPage(int pageNumber);
}
