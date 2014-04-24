package com.lx.web.service;

import com.lx.common.pagination.Page;
import com.lx.common.service.IBaseService;
import com.lx.web.model.User;
import com.lx.web.model.UserQueryModel;

/**
 * User: Zhang Kaitao
 * Date: 12-1-4 上午10:13
 * Version: 1.0
 */
public interface UserService extends IBaseService<User, Integer> {

    Page<User> query(int pn, int pageSize, UserQueryModel command);
}
