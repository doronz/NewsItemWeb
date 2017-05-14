package com.doronzehavi.newsitemweb;

import com.doronzehavi.newsitemweb.dao.item.NewsItemDao;
import com.doronzehavi.newsitemweb.dao.source.NewsSourceDao;
import com.doronzehavi.newsitemweb.dao.user.UserRepository;
import com.doronzehavi.newsitemweb.model.item.NewsItem;
import com.doronzehavi.newsitemweb.model.role.Role;
import com.doronzehavi.newsitemweb.model.source.NewsSource;
import com.doronzehavi.newsitemweb.model.user.User;
import com.doronzehavi.newsitemweb.service.NewsItemLoaderService;
import com.doronzehavi.newsitemweb.service.NewsSourceLoaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Future;

@Component
public class AppRunner implements CommandLineRunner {

    @Autowired
    private NewsSourceDao newsSourceDao;

    @Autowired
    private NewsItemDao newsItemDao;

    @Autowired
    private UserRepository userRepository;


    private final NewsSourceLoaderService newsSourceLoaderService;

    private final NewsItemLoaderService newsItemLoaderService;

    // TODO: Find a better way to do this as this will get large...
    public AppRunner(NewsSourceLoaderService newsSourceLoaderService, NewsItemLoaderService newsItemLoaderService) {
        this.newsSourceLoaderService = newsSourceLoaderService;
        this.newsItemLoaderService = newsItemLoaderService;
    }


    @Override
    public void run(String... args) {

        Set<Role> roleSet = new HashSet<Role>();
        roleSet.add(new Role("admin"));
        roleSet.add(new Role("user"));


        // Create admin user
        // TODO: Only create user if doesn't exist
        userRepository.save(new User("doron", "doron1zehavi@gmail.com", "admin",
                roleSet));

        // TODO: Only load news sources if they haven't been updated in a while
        // TODO: Schedule this
        Future<List<NewsSource>> futureNewsSourcesList = newsSourceLoaderService.fetchAllNewsSourcesFromApi();

        try {
            while (!(futureNewsSourcesList.isDone())) {
                Thread.sleep(50); //50-millisecond pause between each check
            }

            List<NewsSource> newsSourceList = futureNewsSourcesList.get();
            newsSourceDao.saveAll(newsSourceList);

            Future<List<NewsItem>> futureNewsItemList = newsItemLoaderService.fetchAllNewsItemsFromApi();
            while (!(futureNewsItemList.isDone())) {
                Thread.sleep(50); //50-millisecond pause between each check
            }
            List<NewsItem> newsItemList = futureNewsItemList.get();
            newsItemDao.saveAll(newsItemList);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
