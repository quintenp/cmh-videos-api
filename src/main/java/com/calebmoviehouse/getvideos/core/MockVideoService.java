package com.calebmoviehouse.getvideos.core;


import com.calebmoviehouse.getvideos.api.entity.Video;

import java.util.Arrays;
import java.util.List;

public class MockVideoService implements IVideoService {
    public List<Video> getVideos() {
        return Arrays.asList(
                new Video("1", "https://www.youtube.com/watch?v=nbRyOD9trfE","Peppa Pig","Peppa pig video","https://i.ytimg.com/vi/X-4BlfANOIE/default.jpg"),
                new Video("2", "https://www.youtube.com/watch?v=c-zBnUnyYhM","Ben and Holly","Ben and Holly video","https://i.ytimg.com/vi/QNMgUprI-wc/default_live.jpg"));
    }
}
