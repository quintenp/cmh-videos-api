package com.calebmoviehouse.getvideos.core;

import com.calebmoviehouse.getvideos.api.entity.Video;

import java.util.List;

public interface IVideoService{
    List<Video> getVideos();
}
