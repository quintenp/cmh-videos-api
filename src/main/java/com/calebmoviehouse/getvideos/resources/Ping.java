package com.calebmoviehouse.getvideos.resources;

import com.codahale.metrics.annotation.Timed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/test")
public class Ping {
    public Ping(){
    }

    @GET
    @Timed
    @Path("/ping")
    @Produces(MediaType.TEXT_PLAIN)
    public String getPing(){
        return "ping";
    }
}
