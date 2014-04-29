package com.lx.web.service;
import java.util.List;

import com.lx.common.pagination.Page;
import com.lx.common.service.IBaseService;
import com.lx.web.model.Messages;
import com.lx.web.model.User;
import com.lx.web.model.UserQueryModel;

public interface MessageService extends IBaseService<Messages, Long>{  
    public List<Messages> listMessages();  
    public void saveMessage(Messages message);  
    public void deleteMeesage(Messages message);  
    public Messages findMessageById(Long messageId);  
    
    Page<Messages> query(int pn, int pageSize, Messages command);
}  