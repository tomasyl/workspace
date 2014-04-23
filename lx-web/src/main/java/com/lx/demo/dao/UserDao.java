package com.lx.demo.dao;

import java.util.List;

import com.lx.common.dao.IBaseDao;
import com.lx.demo.model.User;
import com.lx.demo.model.UserQueryModel;


public interface UserDao extends IBaseDao<User, Integer> {
    
    List<User> query(int pn, int pageSize, UserQueryModel command);

    int countQuery(UserQueryModel command);

}
