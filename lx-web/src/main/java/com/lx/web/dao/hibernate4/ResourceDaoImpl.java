package com.lx.web.dao.hibernate4;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lx.common.dao.hibernate4.BaseHibernateDao;
import com.lx.web.dao.ResourceDao;
import com.lx.web.model.Resource;

/**
 * User: Zhang Kaitao
 * Date: 11-12-26 下午4:19
 * Version: 1.0
 */
@Repository("resourceDao")
@Transactional
public class ResourceDaoImpl extends BaseHibernateDao<Resource, Integer> implements ResourceDao {

    private static final String HQL_LIST = "from Resource ";
    private static final String HQL_COUNT = "select count(*) from Resource ";

    private static final String HQL_LIST_QUERY_CONDITION = " where ResourceName like ?";
    private static final String HQL_LIST_QUERY_ALL = HQL_LIST + HQL_LIST_QUERY_CONDITION + "order by id desc";
    private static final String HQL_COUNT_QUERY_ALL = HQL_COUNT + HQL_LIST_QUERY_CONDITION;

    
    public List<Resource> query(int pn, int pageSize, Resource command) {
        return list(HQL_LIST_QUERY_ALL, pn, pageSize, getQueryParam(command));
    }

    
    public int countQuery(Resource command) {
        return this.<Number>aggregate(HQL_COUNT_QUERY_ALL, getQueryParam(command)).intValue();
    }
    

    private Object[] getQueryParam(Resource command) {
        //TODO 改成全文索引
        String usernameLikeStr = "%" + command.getName() + "%";
        return new Object[]{
            usernameLikeStr
        };
    }


	public List<Resource> findAll() {
		return listAll();
	}

}
