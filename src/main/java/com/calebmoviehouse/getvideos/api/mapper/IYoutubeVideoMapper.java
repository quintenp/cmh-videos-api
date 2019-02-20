package com.calebmoviehouse.getvideos.api.mapper;

import com.calebmoviehouse.getvideos.api.Video;
import java.util.List;

public interface IYoutubeVideoMapper {
    List<Video> map(String json);
}
