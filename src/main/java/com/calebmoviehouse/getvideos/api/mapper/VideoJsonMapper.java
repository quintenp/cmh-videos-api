package com.calebmoviehouse.getvideos.api.mapper;

import com.calebmoviehouse.getvideos.api.entity.Video;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VideoJsonMapper implements IVideoMapper {
    private ObjectMapper mapper;
    private IUrlMapper urlMapper;
    private List<Video> videoList;

    public VideoJsonMapper() {
        mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        videoList = new ArrayList<>();
        urlMapper = new YoutubeUrlMapper();
    }

    public List<Video> map(String raw) {
        try {
            JsonNode valuesNode = mapper.readTree(raw).get("items");

            for (JsonNode vid : valuesNode) {
                JsonNode snippet = vid.get("snippet");
                String videoId = vid.path("id").path("videoId").asText();

                videoList.add(new Video(
                        videoId,
                        urlMapper.mapUrl(videoId),
                        snippet.path("title").asText(),
                        snippet.path("description").asText(),
                        snippet.path("thumbnails").path("default").path("url").asText()
                        ));
            }
        } catch (IOException e) {
            //Clean up error handling here
            e.printStackTrace();
        }

        return videoList;
    }
}
