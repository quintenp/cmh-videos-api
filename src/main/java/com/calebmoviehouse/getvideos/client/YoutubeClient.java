package com.calebmoviehouse.getvideos.client;

import com.calebmoviehouse.getvideos.api.YoutubeVideo;
import com.calebmoviehouse.getvideos.api.mapper.IYoutubeVideoMapper;
import com.calebmoviehouse.getvideos.api.mapper.YoutubeVideoJsonMapper;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import java.util.List;

public class YoutubeClient {
    private Client client;
    private IYoutubeVideoMapper videoMapper;

    public YoutubeClient() {
        client = ClientBuilder.newClient();
        videoMapper = new YoutubeVideoJsonMapper();
    }

    public String GetTopFiveVideos() {
        String json = client.target("https://www.googleapis.com")
                .path("youtube").path("v3").path("search")
                .queryParam("maxResults", "5")
                .queryParam("part", "snippet")
                .queryParam("q", "baby shows")
                .queryParam("key", "AIzaSyD85NgPxQCxpeBBCWcgYzsIge71KG6dy3Q") //move to env var
                .request(MediaType.APPLICATION_JSON)
                .header("referer", "cmh-api")
                .get(String.class);

        List<YoutubeVideo> videoList = videoMapper.map(json);

        return json;
    }
}
