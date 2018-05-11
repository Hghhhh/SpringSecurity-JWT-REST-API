package com.yidong.controller;


import com.yidong.model.ItemTrack;
import com.yidong.service.ItemTrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class ItemTrackController {
    /**
     * 自动注入itemTrackService
     */
    @Autowired
    private ItemTrackService itemTrackService;

    public void setItemTrackService(ItemTrackService itemTrackService) {

        this.itemTrackService = itemTrackService;
    }

    /**
     *
     * @param itemTrack
     * @return 添加ItemTrack，如果成功则返回1，不成功会返回状态码404
     */
    @RequestMapping("/addItemTrack")
    public ResponseEntity<Integer> AddItemTrack(@RequestBody ItemTrack itemTrack){
        int A=itemTrackService.AddItemtrack(itemTrack);
        if(A==0){
            return new ResponseEntity<Integer>(A,HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Integer>(A,HttpStatus.OK);
    }

    /*
     *  通过user_id查找到对应的所有跟踪表
     */
    @RequestMapping("/selectByUserId")
    public List<ItemTrack> SelectByUserId(@RequestParam String user_id){
        return itemTrackService.SelectByUserId(user_id);
    }

    @RequestMapping("/selectById")
    public ItemTrack SelectById(@RequestParam String id){

        return  itemTrackService.SelectById(id);
    }

    @RequestMapping("/updateById")
    public int UpdateById(@RequestBody ItemTrack itemTrack){
        int a =itemTrackService.UpdateById(itemTrack);
        System.out.print(a+"111111");
        return a;
    }
}
