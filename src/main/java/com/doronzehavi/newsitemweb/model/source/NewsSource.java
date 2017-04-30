package com.doronzehavi.newsitemweb.model.source;

import com.doronzehavi.newsitemweb.model.core.BaseEntity;
import com.doronzehavi.newsitemweb.model.item.NewsItem;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents the source for a FeedItem. Examples
 */
@JsonIgnoreProperties(ignoreUnknown=true)
@Entity
public class NewsSource extends BaseEntity implements ItemSource {

    private String name;

    @Column(length = 512)
    private String description;
    private String url;

    private boolean showInFeed;

    @JsonProperty("id")
    private String newsSourceId;


    @OneToMany(mappedBy = "newsSource", cascade = CascadeType.ALL)
    private List<NewsItem> newsItems;

    protected NewsSource(){
        super();
        this.newsItems = new ArrayList<>();
    }

    public NewsSource(String name, String description, String url) {
        this();
        this.name = name;
        this.description = description;
        this.url = url;
    }

    public String getNewsSourceId() {
        return newsSourceId;
    }

    public void setNewsSourceId(String newsSourceId) {
        this.newsSourceId = newsSourceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public boolean isShowInFeed() {
        return showInFeed;
    }

    public void setShowInFeed(boolean showInFeed) {
        this.showInFeed = showInFeed;
    }
}
