package com.doronzehavi.newsitemweb.dao;

import com.doronzehavi.newsitemweb.model.item.NewsItem;
import com.doronzehavi.newsitemweb.model.source.NewsSource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
public class NewsSourceDaoImpl implements NewsSourceDao {

    private final EntityManagerFactory entityManagerFactory;

    public NewsSourceDaoImpl() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory( "com.doronzehavi.newsitem" );
    }

    @Override
    public void saveAll(List<NewsSource> sources){
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        for (NewsSource newsSource : sources){
            entityManager.persist(newsSource);
        }
        entityManager.getTransaction().commit();

        entityManager.close();
    }

    @Override
    public void save(NewsSource newsSource) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.persist(newsSource);

        entityManager.getTransaction().commit();

        entityManager.close();
    }

    @Override
    public List<NewsSource> fetchAllNewsSources() {

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<NewsSource> criteria = builder.createQuery(NewsSource.class);
        criteria.from(NewsSource.class);

        List<NewsSource> mewsSourceList = entityManager.createQuery(criteria).getResultList();

        entityManager.close();

        return mewsSourceList;
    }
}
