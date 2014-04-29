package com.lx.web.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.lx.common.dao.IBaseDao;
import com.lx.common.pagination.Page;
import com.lx.common.pagination.PageUtil;
import com.lx.common.service.impl.BaseService;
import com.lx.web.dao.UserDao;
import com.lx.web.model.User;
import com.lx.web.model.UserQueryModel;
import com.lx.web.service.UserService;


@Service("userService")
public class UserServiceImpl extends BaseService<User, Integer> implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    private UserDao userDao;

    @Autowired
    @Qualifier("userDao")
    @Override
    public void setBaseDao(IBaseDao<User, Integer> userDao) {
        this.baseDao = userDao;
        this.userDao = (UserDao) userDao;
    }
    


    
    public Page<User> query(int pn, int pageSize, UserQueryModel command) {
        return PageUtil.getPage(userDao.countQuery(command) ,pn, userDao.query(pn, pageSize, command), pageSize);
    }

   
}
