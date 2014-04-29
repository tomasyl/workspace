package com.lx.web.model;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.lx.common.model.AbstractModel;

/*@Entity
@Table(name = "lx_userrole")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)*/
public class UserRole extends AbstractModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2002755587129976358L;
	
	// 延迟加载：多对一方式
	// 关联信息：外键name = "category_id"
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role_id")
	private Role role;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	
}
