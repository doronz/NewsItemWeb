package com.doronzehavi.newsitemweb.model.source;

import com.doronzehavi.newsitemweb.model.core.BaseEntity;
import com.doronzehavi.newsitemweb.model.item.NewsItem;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.*;

import javax.persistence.*;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents the source for a FeedItem. Examples
 */
@JsonIgnoreProperties(ignoreUnknown=true)
@Entity
@Table(name="newssource")
public class NewsSource implements ItemSource {

    @Id
    @JsonProperty("id")
    private String id;

    private String name;

    @Column(length = 512)
    private String description;
    private String url;

    @Column(name = "show_in_feed")
    private boolean showInFeed;


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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
