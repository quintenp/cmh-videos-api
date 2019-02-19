package com.calebmoviehouse.getvideos.api;

public class YoutubeVideo {
    private String description;
    private String title;

    public YoutubeVideo(){
    }

    public YoutubeVideo(String description, String title){
        this.description = description;
        this.title = title;
    }

    public String getDescription(){
        return description;
    }

    public String getTitle(){
        return title;
    }
}
