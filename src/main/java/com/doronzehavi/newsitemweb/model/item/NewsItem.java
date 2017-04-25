package com.doronzehavi.newsitemweb.model.item;

import com.doronzehavi.newsitemweb.model.item.FeedItem;
import com.doronzehavi.newsitemweb.model.source.NewsSource;

import javax.persistence.*;
import java.util.Date;

@Entity
public class NewsItem implements FeedItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;
    private String summary;
    private String url;
    private Date date;

    @ManyToOne
    private NewsSource newsSource;

    public NewsItem(){}

    @Override
    public String toString() {
        return "NewsItem{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", summary='" + summary + '\'' +
                ", url='" + url + '\'' +
                ", date=" + date +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
