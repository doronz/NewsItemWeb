package com.doronzehavi.newsitemweb.model.item;

import com.doronzehavi.newsitemweb.model.source.NewsSource;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import java.util.List;


public class NewsItemResponse {
    @JsonProperty("articles")
    private List<NewsItem> newsItemList;

    @JsonProperty("source")
    private String sourceId;

    // TODO: Map NewsSource ID for each item

    public List<NewsItem> getNewsItemList() {
        return newsItemList;
    }

    public void setNewsItemList(List<NewsItem> newsItemList) {
        this.newsItemList = newsItemList;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }
}
