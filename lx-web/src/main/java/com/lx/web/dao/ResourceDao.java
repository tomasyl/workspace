package com.lx.web.dao;

import java.util.List;

import com.lx.common.dao.IBaseDao;
import com.lx.web.model.Resource;


public interface ResourceDao extends IBaseDao<Resource, Integer> {
    
    List<Resource> query(int pn, int pageSize, Resource command);

    int countQuery(Resource command);

	List<Resource> findAll();

}
