package com.lx.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.lx.common.dao.IBaseDao;
import com.lx.common.pagination.Page;
import com.lx.common.pagination.PageUtil;
import com.lx.common.service.impl.BaseService;
import com.lx.web.dao.MessageDao;
import com.lx.web.model.Messages;
import com.lx.web.service.MessageService;

@Service("messageService")
public class MessageServiceImpl extends BaseService<Messages, Long> implements MessageService {
	
	private MessageDao messageDao;
	
	@Autowired
    @Qualifier("messageDao")
    @Override
    public void setBaseDao(IBaseDao<Messages, Long> messageDao) {
        this.baseDao = messageDao;
       
        this.messageDao = (MessageDao) messageDao;
    }
	
	public Page<Messages> query(int pn, int pageSize, Messages command) {
        return PageUtil.getPage(messageDao.countQuery(command) ,pn, messageDao.query(pn, pageSize, command), pageSize);
    }
	
	// @Secured( { "ROLE_ADMIN", "IP_LOCAL_HOST" })
	public synchronized void deleteMeesage(long messageId) {
		
	}

	// @Secured( { "ROLE_USER", "ROLE_GUEST" })
	public List<Messages> listMessages() {
		return messageDao.findAll();
	}

	// @Secured( { "ROLE_USER" })
	public synchronized void saveMessage(Messages message) {
		messageDao.save(message);
	}


	public void deleteMeesage(Messages message) {
		
		messageDao.deleteObject(message);
	}


	public Messages findMessageById(Long messageId) {
		return messageDao.get(messageId);
	}

}