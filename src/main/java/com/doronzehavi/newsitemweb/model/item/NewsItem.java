package com.doronzehavi.newsitemweb.model.item;

import com.doronzehavi.newsitemweb.model.core.BaseEntity;
import com.doronzehavi.newsitemweb.model.item.FeedItem;
import com.doronzehavi.newsitemweb.model.source.NewsSource;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.text.DateFormat;
import java.util.Date;

@Entity
@Table(name="newsitem")
public class NewsItem extends BaseEntity implements FeedItem {

    private static final int TITLE_LENGTH = 255;
    private static final int AUTHOR_LENGTH = 127;
    private static final int SUMMARY_LENGTH = 512;

    @Column(length = 512)
    private String author;
    @NotNull
    @Size(min = 3)
    @Column(length = 512)
    private String title;
    @JsonProperty("description")
    @Column(length = 512)
    private String summary;
    @NotNull
    @Column(length = 512)
    private String url;
    // TODO: find out why the underscores are being added by the framework
    @Column(length = 512, name = "url_to_image")
    private String urlToImage;
    @JsonProperty("publishedAt")
    @DateTimeFormat(pattern = "dd/mm/yyyy")
    private Date date;

    @ManyToOne
    @JoinColumn(name="newssource")
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
        if (title == null) return;
        this.title = title.length() > TITLE_LENGTH ? title.substring(0, TITLE_LENGTH) : title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if (author == null) return;
        this.author = author.length() > AUTHOR_LENGTH ? author.substring(0, AUTHOR_LENGTH) : author;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        if (summary == null) return;
        this.summary = summary.length() > SUMMARY_LENGTH ? summary.substring(0, SUMMARY_LENGTH) : summary;
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
