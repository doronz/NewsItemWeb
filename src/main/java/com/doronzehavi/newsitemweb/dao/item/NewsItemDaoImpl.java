package com.doronzehavi.newsitemweb.dao.item;

import com.doronzehavi.newsitemweb.model.item.NewsItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NewsItemDaoImpl implements NewsItemDao{

    private static final int PAGE_SIZE = 16;

    private final NewsItemRepository newsItemRepository;

    @Autowired
    public NewsItemDaoImpl(NewsItemRepository newsItemRepository) {
        this.newsItemRepository = newsItemRepository;
    }

    @Override
    public Page<NewsItem> fetchNewsItemsByPage(int pageNumber) {
        PageRequest request =
                new PageRequest(pageNumber - 1, PAGE_SIZE, Sort.Direction.DESC, "date");
        return newsItemRepository.findAll(request);
    }

    @Override
    public void saveAll(List<NewsItem> newsItems){
        for (NewsItem newsItem : newsItems){
            newsItemRepository.save(newsItem);
        }
    }

    @Override
    public NewsItem save(NewsItem newsItem) {
        return newsItemRepository.save(newsItem);
    }

}
