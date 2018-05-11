package com.yidong.service.impl;

import com.yidong.mapper.DepartmentMapper;
import com.yidong.mapper.ItemTrackMapper;
import com.yidong.mapper.UserMapper;
import com.yidong.model.ItemTrack;
import com.yidong.model.User;
import com.yidong.service.ItemTrackService;
import com.yidong.service.UserService;
import com.yidong.util.Time;
import com.yidong.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ItemTrackServiceImpl implements ItemTrackService {

    @Autowired
    private ItemTrackMapper itemTrackMapper;
    private DepartmentMapper departmentMapper;
    /**
     *
     * @param itemTrack
     * @return 如果添加操作成功返回1，否则0
     */
    @Override
    public int AddItemtrack(ItemTrack itemTrack) {
        itemTrack.setId(UUIDUtils.getUUID());
        String id=itemTrack.getUserId();
        UserService userService=new UserServiceImpl();
        User user=userService.getUser(id);
        itemTrack.setName(user.getName());
        itemTrack.setTelephone(user.getTelephone());
        itemTrack.setEmail(user.getEmail());
        itemTrack.setDepartment(getDepartmentName(user.getDepartment()));
        itemTrack.setApplyYear(Time.getTime());
        return itemTrackMapper.insert(itemTrack);
    }

    /*
      通过user_id（用户的ID）来获取跟踪表的信息
     */
    @Override
    public List<ItemTrack> SelectByUserId(String user_id) {

        return itemTrackMapper.selectByUserId(user_id);
    }

    /*
       通过跟踪表的ID来检索获取表格信息
     */
    @Override
    public ItemTrack SelectById(String id) {

        return itemTrackMapper.selectById(id);
    }

    /*
      更新ID所对应的跟踪表的信息
     */
    @Override
    public int UpdateById(ItemTrack itemTrack) {

        return itemTrackMapper.updateById(itemTrack);
    }

    // 通过部门id获取部门名字
    public String getDepartmentName(String id) {
        HashMap<String, String> hashmap =departmentMapper.select();
        String val = (String) hashmap.get(id);
        return val;
    }

}
