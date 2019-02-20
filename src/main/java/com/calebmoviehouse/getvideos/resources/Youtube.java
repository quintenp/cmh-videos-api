package com.calebmoviehouse.getvideos.resources;

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

@Path("youtube")
public class Youtube {

    private YoutubeClient youtubeClient;

    public Youtube(){
        youtubeClient = new YoutubeClient();
    }

    @GET
    @Timed
    @Path("/popular")
    @Produces(MediaType.APPLICATION_JSON)
    public String getTopFiveVideos(){
        return youtubeClient.GetTopFiveVideos(5,"Baby Shows");
    }
}
