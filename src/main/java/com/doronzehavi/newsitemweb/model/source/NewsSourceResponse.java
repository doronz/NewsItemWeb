package com.doronzehavi.newsitemweb.model.source;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import java.util.List;


public class NewsSourceResponse {
    @JsonProperty("sources")
    private List<NewsSource> sourceList;

    public List<NewsSource> getSourceList() {
        return sourceList;
    }

    public void setSourceList(List<NewsSource> sourceList) {
        this.sourceList = sourceList;
    }
}
