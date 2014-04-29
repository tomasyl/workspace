package com.lx.web.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.lx.common.model.AbstractModel;

@Entity
@Table(name = "lx_role")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Role extends AbstractModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8318776285587635345L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private int id;

	private String roleName = "";

	private int enable = 1;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "lx_roleresource", // 这里的name是数据库中间表名
	joinColumns = { @JoinColumn(name = "role_id") }, // 本表在中间表的外键名称
	inverseJoinColumns = { @JoinColumn(name = "resource_id") })
	private Set<Resource> resources;

	public Set<Resource> getResources() {
		return resources;
	}

	public void setResources(Set<Resource> resources) {
		this.resources = resources;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public int getEnable() {
		return enable;
	}

	public void setEnable(int enable) {
		this.enable = enable;
	}

}
