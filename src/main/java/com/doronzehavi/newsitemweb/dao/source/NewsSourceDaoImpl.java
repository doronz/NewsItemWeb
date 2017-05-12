package com.doronzehavi.newsitemweb.dao.source;

import com.doronzehavi.newsitemweb.model.source.NewsSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class NewsSourceDaoImpl implements NewsSourceDao {

    private final NewsSourceRepository newsSourceRepository;

    @Autowired
    public NewsSourceDaoImpl(NewsSourceRepository newsSourceRepository) {
        this.newsSourceRepository = newsSourceRepository;
    }

    @Override
    public void saveAll(List<NewsSource> sources){
        for (NewsSource newsSource : sources){
            newsSourceRepository.save(newsSource);
        }
    }

    @Override
    public NewsSource save(NewsSource newsSource) {
        return newsSourceRepository.save(newsSource);
    }

    @Override
    public List<NewsSource> findAll() {
        List<NewsSource> results = new ArrayList<>();
        for (NewsSource newsSource : newsSourceRepository.findAll(sortByNameAsc())) {
            results.add(newsSource);
        }
        return results;
    }

    private Sort sortByNameAsc() {
        return new Sort(Sort.Direction.ASC, "name");
    }

}
