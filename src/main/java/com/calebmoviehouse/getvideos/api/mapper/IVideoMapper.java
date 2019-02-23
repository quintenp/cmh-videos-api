package com.calebmoviehouse.getvideos.api.mapper;

import com.calebmoviehouse.getvideos.api.entity.Video;
import java.util.List;

public interface IVideoMapper {
    List<Video> map(String json);
}
