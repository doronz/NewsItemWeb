package com.doronzehavi.newsitemweb.model.item;

import com.doronzehavi.newsitemweb.model.source.NewsSource;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import java.util.List;


public class NewsItemResponse {
    @JsonProperty("articles")
    private List<NewsItem> newsItemList;

    public List<NewsItem> getNewsItemList() {
        return newsItemList;
    }

    public void setNewsItemList(List<NewsItem> newsItemList) {
        this.newsItemList = newsItemList;
    }

}
