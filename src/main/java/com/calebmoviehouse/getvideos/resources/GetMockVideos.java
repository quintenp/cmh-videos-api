package com.calebmoviehouse.getvideos.resources;

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

    public GetMockVideos(){
        mockVideoService = new MockVideoService();
    }

    @GET
    @Timed
    @Path("/getvideos")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Video> getVideoList(){
        return mockVideoService.getVideos();
    }
}
