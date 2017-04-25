package com.doronzehavi.newsitemweb.dao;

import com.doronzehavi.newsitemweb.model.item.NewsItem;
import com.doronzehavi.newsitemweb.model.source.NewsSource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
public class NewsSourceDaoImpl implements NewsSourceDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveAll(List<NewsSource> sources){
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        for (NewsSource newsSource : sources){
            session.saveOrUpdate(newsSource);
        }
        session.getTransaction().commit();

        session.close();
    }

    @Override
    public void save(NewsSource newsSource) {
        // Open a session
        Session session = sessionFactory.openSession();

        // Begin a transaction
        session.beginTransaction();

        // Save the news source
        session.saveOrUpdate(newsSource);

        // Commit the transaction
        session.getTransaction().commit();

        // Close the session
        session.close();
    }

    @Override
    public List<NewsSource> fetchAllNewsSources() {

        Session session = sessionFactory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<NewsSource> criteria = builder.createQuery(NewsSource.class);
        criteria.from(NewsSource.class);

        List<NewsSource> mewsSourceList = session.createQuery(criteria).getResultList();

        session.close();

        return mewsSourceList;
    }
}
