package com.doronzehavi.newsitemweb.dao;

import com.doronzehavi.newsitemweb.model.item.NewsItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class NewsItemDaoImpl implements NewsItemDao{

    private final EntityManagerFactory entityManagerFactory;

    public NewsItemDaoImpl() {
        entityManagerFactory = Persistence.createEntityManagerFactory( "com.doronzehavi.newsitem" );

    }

    @Override
    public List<NewsItem> fetchAllNewsItems() {

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<NewsItem> criteria = builder.createQuery(NewsItem.class);
        Root<NewsItem> newsItemRoot = criteria.from(NewsItem.class);
        criteria.orderBy(builder.desc(newsItemRoot.get("date")));

        List<NewsItem> newsItemList = entityManager.createQuery(criteria).getResultList();

        entityManager.close();

        return newsItemList;
    }

    @Override
    public void saveAll(List<NewsItem> newsItems){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        for (NewsItem newsItem : newsItems){
            entityManager.persist(newsItem);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void save(NewsItem newsItem) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(newsItem);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

}
