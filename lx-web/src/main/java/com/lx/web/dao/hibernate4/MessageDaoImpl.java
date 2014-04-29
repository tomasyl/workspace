package com.lx.web.dao.hibernate4;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lx.common.dao.hibernate4.BaseHibernateDao;
import com.lx.web.dao.MessageDao;
import com.lx.web.model.Messages;


@Repository("messageDao")
public class MessageDaoImpl extends BaseHibernateDao<Messages, Long> implements MessageDao {

    private static final String HQL_LIST = "from Message ";
    private static final String HQL_COUNT = "select count(*) from Message ";

    private static final String HQL_LIST_QUERY_CONDITION = " where ResourceName like ?";
    private static final String HQL_LIST_QUERY_ALL = HQL_LIST + HQL_LIST_QUERY_CONDITION + "order by id desc";
    private static final String HQL_COUNT_QUERY_ALL = HQL_COUNT + HQL_LIST_QUERY_CONDITION;

    
    public List<Messages> query(int pn, int pageSize, Messages command) {
        return list(HQL_LIST_QUERY_ALL, pn, pageSize, getQueryParam(command));
    }

    
    public int countQuery(Messages command) {
        return this.<Number>aggregate(HQL_COUNT_QUERY_ALL, getQueryParam(command)).intValue();
    }
    

    private Object[] getQueryParam(Messages command) {
        //TODO 改成全文索引
        String usernameLikeStr = "%" + command.getTitle() + "%";
        return new Object[]{
            usernameLikeStr
        };
    }


	public List<Messages> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
