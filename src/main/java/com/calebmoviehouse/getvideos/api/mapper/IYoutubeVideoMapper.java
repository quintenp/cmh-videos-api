package com.calebmoviehouse.getvideos.api.mapper;

import com.calebmoviehouse.getvideos.api.YoutubeVideo;
import java.util.List;

public interface IYoutubeVideoMapper {
    List<YoutubeVideo> map(String json);
}
