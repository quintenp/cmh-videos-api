package com.calebmoviehouse.getvideos.api.mapper;

public class YoutubeUrlMapper implements IUrlMapper {
    private static final String youtubeUrl = "https://www.youtube.com/watch?v="; //Replace with env var

    public String mapUrl(String videoId) {
        return youtubeUrl + videoId;
    }
}
