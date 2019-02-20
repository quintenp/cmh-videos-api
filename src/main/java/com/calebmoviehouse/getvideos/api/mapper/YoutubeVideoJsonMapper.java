package com.calebmoviehouse.getvideos.api.mapper;

import com.calebmoviehouse.getvideos.api.Video;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class YoutubeVideoJsonMapper implements IYoutubeVideoMapper {
    private ObjectMapper mapper;
    private List<Video> videoList;

    public YoutubeVideoJsonMapper() {
        mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        videoList = new ArrayList<>();
    }

    public List<Video> map(String raw) {
        try {
            JsonNode valuesNode = mapper.readTree(raw).get("items");

            for (JsonNode vid : valuesNode) {
                JsonNode snippet = vid.get("snippet");

                videoList.add(new Video(
                        snippet.path("id").path("id").asLong(),
                        snippet.path("url").asText(),
                        snippet.path("title").asText(),
                        snippet.path("description").asText()));
            }
        } catch (IOException e) {
            //Clean up error handling here
            e.printStackTrace();
        }

        return videoList;
    }
}
