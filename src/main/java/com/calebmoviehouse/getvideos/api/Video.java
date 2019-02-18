package com.calebmoviehouse.getvideos.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Video {
    private long id;
    private String url;

    public Video(){
    }

    public Video(long id, String url){
        this.id = id;
        this.url = url;
    }

    @JsonProperty
    public long getId(){
        return id;
    }

    @JsonProperty
    public String getUrl(){
        return url;
    }
}
