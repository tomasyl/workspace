package com.lx.web.dao;

import java.util.List;

import com.lx.common.dao.IBaseDao;
import com.lx.web.model.User;
import com.lx.web.model.UserQueryModel;


public interface UserDao extends IBaseDao<User, Integer> {
    
    List<User> query(int pn, int pageSize, UserQueryModel command);

    int countQuery(UserQueryModel command);

}
