package com.lx.web.dao;

import java.util.List;

import com.lx.common.dao.IBaseDao;
import com.lx.web.model.Role;
import com.lx.web.model.User;


public interface RoleDao extends IBaseDao<Role, Integer> {
    
    List<Role> query(int pn, int pageSize, Role command);

    int countQuery(Role command);

}
