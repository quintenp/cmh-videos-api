package com.calebmoviehouse.getvideos.core;


import com.calebmoviehouse.getvideos.api.Video;

import java.util.Arrays;
import java.util.List;

public class MockVideoService implements IVideoService {
    public List<Video> getVideos() {
        return Arrays.asList(
                new Video(1, "https://www.youtube.com/watch?v=nbRyOD9trfE"),
                new Video(2, "https://www.youtube.com/watch?v=c-zBnUnyYhM"));
    }
}
