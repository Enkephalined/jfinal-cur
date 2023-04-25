package com.jfinal.cur.service;

import com.jfinal.cur.model.User;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

/**
 * @author Zheng Yipeng
 * @description
 * @create 2023/3/31 20:19
 */
public class UserService {

    public User findUserEntityByUsername(String username){
        Record userRecord = Db.findFirst("select * from t_user where username = ?", username);
        if(userRecord == null) return null;
        User userEntity = new User(userRecord.getInt("user_id"), userRecord.get("username"), userRecord.get("password"));
        return userEntity;
    }

    public User findUserEntityByUserId(Integer userId){
        Record userRecord = Db.findFirst("select * from t_user where user_id = ?", userId);
        if(userRecord == null) return null;
        User userEntity = new User(userRecord.getInt("user_id"), userRecord.get("username"), userRecord.get("password"));
        return userEntity;
    }

    public void deleteUserByUserId(Integer userId){
        Db.deleteById("t_user", "user_id", userId);
    }

    public void saveUserByUserRecord(Record userRecord){
        Db.save("t_user", "user_id", userRecord);
    }

    public void updateUserByUserRecord(Record userRecord){
        Db.update("t_user", "user_id", userRecord);
    }

}
