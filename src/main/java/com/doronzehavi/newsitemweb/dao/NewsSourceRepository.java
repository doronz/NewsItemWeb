package com.doronzehavi.newsitemweb.dao;


import com.doronzehavi.newsitemweb.model.item.NewsItem;
import com.doronzehavi.newsitemweb.model.source.NewsSource;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface NewsSourceRepository extends PagingAndSortingRepository<NewsSource, Long> {
    public NewsSource save(NewsSource newsSource);
}
