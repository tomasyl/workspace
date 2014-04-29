package com.lx.web.model;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.lx.common.model.AbstractModel;

/*@Entity
@Table(name = "lx_roleresource")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)*/
public class RoleResource extends AbstractModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2002755587129976358L;
	
	// 延迟加载：多对一方式
	// 关联信息：外键name = "category_id"
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "resource_id")
	private Resource resource;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role_id")
	private Role role;

	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	
}
