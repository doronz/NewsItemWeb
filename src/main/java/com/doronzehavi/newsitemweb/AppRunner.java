package com.doronzehavi.newsitemweb;

import com.doronzehavi.newsitemweb.dao.NewsSourceDao;
import com.doronzehavi.newsitemweb.model.source.NewsSource;
import com.doronzehavi.newsitemweb.service.NewsSourceLoaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.Future;

@Component
public class AppRunner implements CommandLineRunner {

    @Autowired
    private NewsSourceDao newsSourceDao;

    private final NewsSourceLoaderService newsSourceLoaderService;

    public AppRunner(NewsSourceLoaderService gitHubLookupService) {
        this.newsSourceLoaderService = gitHubLookupService;
    }


    @Override
    public void run(String... args) throws Exception {
        Future<List<NewsSource>> futureNewsSourcesList = newsSourceLoaderService.fetchAllNewsSourcesFromApi();

        while (!(futureNewsSourcesList.isDone())) {
            Thread.sleep(50); //50-millisecond pause between each check
        }

        List<NewsSource> newsSourceList = futureNewsSourcesList.get();
        newsSourceDao.saveAll(newsSourceList);

    }
}
