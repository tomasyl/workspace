package com.lx.web.dao.hibernate4;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lx.common.dao.hibernate4.BaseHibernateDao;
import com.lx.web.dao.RoleDao;
import com.lx.web.model.Role;
import com.lx.web.model.User;
import com.lx.web.model.UserQueryModel;

/**
 * User: Zhang Kaitao
 * Date: 11-12-26 下午4:19
 * Version: 1.0
 */
@Repository("roleDao")
public class RoleDaoImpl extends BaseHibernateDao<Role, Integer> implements RoleDao {

    private static final String HQL_LIST = "from Role ";
    private static final String HQL_COUNT = "select count(*) from Role ";

    private static final String HQL_LIST_QUERY_CONDITION = " where roleName like ?";
    private static final String HQL_LIST_QUERY_ALL = HQL_LIST + HQL_LIST_QUERY_CONDITION + "order by id desc";
    private static final String HQL_COUNT_QUERY_ALL = HQL_COUNT + HQL_LIST_QUERY_CONDITION;

    
    public List<Role> query(int pn, int pageSize, Role command) {
        return list(HQL_LIST_QUERY_ALL, pn, pageSize, getQueryParam(command));
    }

    
    public int countQuery(Role command) {
        return this.<Number>aggregate(HQL_COUNT_QUERY_ALL, getQueryParam(command)).intValue();
    }
    

    private Object[] getQueryParam(Role command) {
        //TODO 改成全文索引
        String usernameLikeStr = "%" + command.getRoleName() + "%";
        return new Object[]{
            usernameLikeStr
        };
    }

}
