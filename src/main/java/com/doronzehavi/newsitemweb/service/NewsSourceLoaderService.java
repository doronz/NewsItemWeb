package com.doronzehavi.newsitemweb.service;

import com.doronzehavi.newsitemweb.model.source.NewsSource;

import java.util.List;
import java.util.concurrent.Future;


public interface NewsSourceLoaderService {
    public Future<List<NewsSource>> fetchAllNewsSourcesFromApi();
}
