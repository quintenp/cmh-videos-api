package com.calebmoviehouse.getvideos.resources;

import com.calebmoviehouse.getvideos.core.IVideoService;
import com.calebmoviehouse.getvideos.core.MockVideoService;
import com.calebmoviehouse.getvideos.api.entity.Video;
import com.codahale.metrics.annotation.Timed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("mock")
public class MockVideos {

    private IVideoService mockVideoService;

    public MockVideos(){
        mockVideoService = new MockVideoService();
    }

    @GET
    @Timed
    @Path("/videos")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Video> getVideoList(){
        return mockVideoService.getVideos();
    }

}
