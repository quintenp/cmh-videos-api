package com.calebmoviehouse.getvideos.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class YoutubeVideo {
    private String description;
    private String title;

    public YoutubeVideo(){
    }

    public YoutubeVideo( String description, String title){
        this.description = description;
        this.title = title;
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
