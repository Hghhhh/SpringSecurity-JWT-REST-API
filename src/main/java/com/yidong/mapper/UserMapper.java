/**
 * mapper层相当于原来的Dao层，Usermapper与mabatis的UserMapper.xml对应
 */
package com.yidong.mapper;

import com.yidong.model.User;

public interface UserMapper {

    /**
     * 根据账号找用户
     * @param account
     * @return User
     */
    User selectByAccount(String account);

    User getUser(String id);

}