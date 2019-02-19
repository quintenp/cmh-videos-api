package com.calebmoviehouse.getvideos.client;

import com.calebmoviehouse.getvideos.api.YoutubeSearchResult;
import com.calebmoviehouse.getvideos.api.YoutubeVideo;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class YoutubeClient {

    public String TestResult() {
        Client client = ClientBuilder.newClient();
        String json = client.target("https://www.googleapis.com")
                .path("youtube").path("v3").path("search")
                .queryParam("maxResults", "5")
                .queryParam("part", "snippet")
                .queryParam("q", "babyshows")
                .queryParam("key", "AIzaSyD85NgPxQCxpeBBCWcgYzsIge71KG6dy3Q") //move to env var
                .request(MediaType.APPLICATION_JSON)
                .header("referer", "cmh-api")
                .get(String.class);

        try {
            //Move to dedicated mapper class
            ObjectMapper mapper = new ObjectMapper();
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            JsonNode valuesNode = mapper.readTree(json).get("items");

            List<String> videos = new ArrayList<>();

            for (JsonNode vid : valuesNode) {
                videos.add(vid.path("snippet").path("title").asText());
            }
        } catch (IOException e) {
            //Clean up error handling here
            e.printStackTrace();
        }

        return json;
    }
}
