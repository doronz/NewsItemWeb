package com.doronzehavi.newsitemweb.service;

import com.doronzehavi.newsitemweb.model.item.NewsItem;

import java.util.List;

public interface NewsItemService {
    public List<NewsItem> fetchAllNewsItems();
}
