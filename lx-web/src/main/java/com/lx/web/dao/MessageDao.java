package com.lx.web.dao;

import java.util.List;

import com.lx.common.dao.IBaseDao;
import com.lx.web.model.Messages;


public interface MessageDao extends IBaseDao<Messages, Long> {
    
    List<Messages> query(int pn, int pageSize, Messages command);

    int countQuery(Messages command);

	List<Messages> findAll();

}
