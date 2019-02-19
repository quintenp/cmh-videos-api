package com.calebmoviehouse.getvideos.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class YoutubeSearchResult {
    private long id;
    private List<YoutubeVideo> items;
    private String thumbnailUrl;
    private String title;

    public YoutubeSearchResult(){
    }

    public YoutubeSearchResult(long id, List<YoutubeVideo> items){
        this.id = id;
        this.items = items;
    }

    @JsonProperty
    public long getId(){
        return id;
    }

    @JsonProperty
    public List<YoutubeVideo> getItems(){
        return items;
    }
}
