package com.calebmoviehouse.getvideos.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Video {
    private long id;
    private String url;
    private String description;
    private String title;

    public Video(){
    }

    public Video(long id, String url, String title, String description){
        this.id = id;
        this.url = url;
        this.description = description;
        this.title = title;
    }

    @JsonProperty
    public long getId(){
        return id;
    }

    @JsonProperty
    public String getUrl(){
        return url;
    }

    @JsonProperty
    public String getDescription(){
        return description;
    }

    @JsonProperty
    public String getTitle(){
        return title;
    }
}
