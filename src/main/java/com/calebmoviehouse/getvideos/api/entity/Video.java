package com.calebmoviehouse.getvideos.api.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Video {
    private String id;
    private String url;
    private String description;
    private String title;
    private String thumbnail;

    public Video(){
    }

    public Video(String id, String url, String title, String description, String thumbnail){
        this.id = id;
        this.url = url;
        this.description = description;
        this.title = title;
        this.thumbnail = thumbnail;
    }

    @JsonProperty
    public String getId(){
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

    @JsonProperty
    public String getThumbnail(){
        return thumbnail;
    }
}
