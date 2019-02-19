package com.calebmoviehouse.getvideos.resources;

import com.calebmoviehouse.getvideos.api.YoutubeVideo;
import com.calebmoviehouse.getvideos.client.YoutubeClient;
import com.calebmoviehouse.getvideos.core.IVideoService;
import com.calebmoviehouse.getvideos.core.MockVideoService;
import com.calebmoviehouse.getvideos.api.Video;
import com.codahale.metrics.annotation.Timed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("mock")
public class GetMockVideos {

    private IVideoService mockVideoService;
    private YoutubeClient youtubeClient;

    public GetMockVideos(){
        mockVideoService = new MockVideoService();
        youtubeClient = new YoutubeClient();
    }

    @GET
    @Timed
    @Path("/videos")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Video> getVideoList(){
        return mockVideoService.getVideos();
    }

    @GET
    @Timed
    @Path("/videosTest")
    @Produces(MediaType.APPLICATION_JSON)
    public String getVideoListTest(){
        return youtubeClient.GetTopFiveVideos();
    }
}
