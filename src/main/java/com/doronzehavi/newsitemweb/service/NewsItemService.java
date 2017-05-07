package com.doronzehavi.newsitemweb.service;

import com.doronzehavi.newsitemweb.model.item.NewsItem;
import org.springframework.data.domain.Page;

import java.util.List;

public interface NewsItemService {
    public Page<NewsItem> fetchNewsItemsByPage(int pageNumber);
}
