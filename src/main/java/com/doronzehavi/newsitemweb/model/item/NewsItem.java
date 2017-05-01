package com.doronzehavi.newsitemweb.model.item;

import com.doronzehavi.newsitemweb.model.core.BaseEntity;
import com.doronzehavi.newsitemweb.model.item.FeedItem;
import com.doronzehavi.newsitemweb.model.source.NewsSource;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.text.DateFormat;
import java.util.Date;

@Entity
@Table(name="newsitem")
public class NewsItem extends BaseEntity implements FeedItem {

    private static final int TITLE_LENGTH = 255;

    private String author;
    private String title;
    @Column(length = 512)
    @JsonProperty("description")
    private String summary;
    private String url;
    // TODO: find out why the underscores are being added by the framework
    @Column(length = 512, name = "url_to_image")
    private String urlToImage;
    @JsonProperty("publishedAt")
    @DateTimeFormat(pattern = "dd/mm/yyyy")
    private Date date;

    @ManyToOne
    @JoinColumn(name="newssource_id")
    private NewsSource newsSource;

    protected NewsItem(){
        super();
    }

    public NewsSource getNewsSource() {
        return newsSource;
    }

    public void setNewsSource(NewsSource newsSource) {
        this.newsSource = newsSource;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title.length() > TITLE_LENGTH ? title.substring(0,TITLE_LENGTH) : title;
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
        try {
            int size = getClass().getDeclaredField("summary").getAnnotation(Column.class).length();
            int inLength = summary.length();
            if (inLength > size)
            {
                summary = summary.substring(0, size);
            }
        } catch (NoSuchFieldException | SecurityException | NullPointerException ex) {
        }
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

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }
}
