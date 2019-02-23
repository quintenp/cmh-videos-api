package com.calebmoviehouse.getvideos.client;

import com.calebmoviehouse.getvideos.api.entity.Video;
import com.calebmoviehouse.getvideos.api.mapper.IVideoMapper;
import com.calebmoviehouse.getvideos.api.mapper.VideoJsonMapper;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import java.util.List;

public class YoutubeClient {
    private Client client;
    private IVideoMapper videoMapper;

    private static final String youtubeKey = System.getenv("YoutubeKey");
    private static final String referer = "cmh-api";
    private static final String part = "snippet";

    public YoutubeClient() {
        client = ClientBuilder.newClient();
        videoMapper = new VideoJsonMapper();
    }

    public List<Video> GetTopFiveVideos(int maxResults, String query) {
        String resultingJson = client.target("https://www.googleapis.com")
                .path("youtube").path("v3").path("search")
                .queryParam("maxResults", maxResults)
                .queryParam("part", part)
                .queryParam("q", query)
                .queryParam("key", youtubeKey) //move to env var
                .request(MediaType.APPLICATION_JSON)
                .header("referer", referer)
                .get(String.class);

        List<Video> videoList = videoMapper.map(resultingJson);

        return videoList;
    }
}
