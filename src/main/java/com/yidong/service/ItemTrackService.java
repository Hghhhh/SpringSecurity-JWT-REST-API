package com.yidong.service;

import com.yidong.model.ItemTrack;

import java.util.List;

public interface ItemTrackService {
    public int AddItemtrack(ItemTrack itemTrack);
    public List<ItemTrack> SelectByUserId(String user_id);
    public ItemTrack SelectById(String id);
    public int UpdateById(ItemTrack itemTrack);
}
