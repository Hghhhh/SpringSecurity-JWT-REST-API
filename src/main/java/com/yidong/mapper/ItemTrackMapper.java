package com.yidong.mapper;

import com.yidong.model.ItemTrack;

import java.util.List;
import java.util.Map;

public interface ItemTrackMapper {
    int insert(ItemTrack record);

    List<ItemTrack> selectByUserId(String user_id);

    ItemTrack selectById(String id);

    int updateById(ItemTrack itemTrack);

    int selectByApplyField(Map<String,String> message);
}