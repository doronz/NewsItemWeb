package com.doronzehavi.newsitemweb.service;


import com.doronzehavi.newsitemweb.model.item.NewsItem;

import java.util.List;
import java.util.concurrent.Future;

public interface NewsItemLoaderService {
    public Future<List<NewsItem>> fetchAllNewsSourcesFromApi();
}
