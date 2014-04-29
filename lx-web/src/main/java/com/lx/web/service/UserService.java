package com.lx.web.service;

import com.lx.common.pagination.Page;
import com.lx.common.service.IBaseService;
import com.lx.web.model.User;
import com.lx.web.model.UserQueryModel;


public interface UserService extends IBaseService<User, Integer> {

    Page<User> query(int pn, int pageSize, UserQueryModel command);
}
