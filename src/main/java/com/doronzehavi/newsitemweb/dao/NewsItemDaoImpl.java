package com.doronzehavi.newsitemweb.dao;

import com.doronzehavi.newsitemweb.model.item.NewsItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
public class NewsItemDaoImpl implements NewsItemDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<NewsItem> fetchAllNewsItems() {

        Session session = sessionFactory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<NewsItem> criteria = builder.createQuery(NewsItem.class);
        criteria.from(NewsItem.class);

        List<NewsItem> newsItemList = session.createQuery(criteria).getResultList();

        session.close();

        return newsItemList;
    }

    @Override
    public void saveAll(List<NewsItem> newsItems){
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        for (NewsItem newsItem : newsItems){
            session.saveOrUpdate(newsItem);
        }
        session.getTransaction().commit();

        session.close();
    }

    @Override
    public void save(NewsItem newsItem) {
        // Open a session
        Session session = sessionFactory.openSession();

        // Begin a transaction
        session.beginTransaction();

        // Save the news newsItem
        session.saveOrUpdate(newsItem);

        // Commit the transaction
        session.getTransaction().commit();

        // Close the session
        session.close();
    }

}
