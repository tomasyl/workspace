package com.lx.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.transaction.annotation.Transactional;

import com.lx.web.dao.ResourceDao;
import com.lx.web.model.Resource;

//1 加载资源与权限的对应关系
@Transactional
public class LXSecurityMetadataSource implements
		FilterInvocationSecurityMetadataSource {

	private ResourceDao resourceDao;

	public LXSecurityMetadataSource(ResourceDao resourceDao) {
		this.resourceDao = resourceDao;
		loadResourceDefine();
	}

	private static Map<String, Collection<ConfigAttribute>> resourceMap = null;

	public ResourceDao getResourceDao() {
		return resourceDao;
	}

	public void setResourceDao(ResourceDao resourceDao) {
		this.resourceDao = resourceDao;
	}

	public Collection<ConfigAttribute> getAllConfigAttributes() {
		
		return null;
	}

	public boolean supports(Class<?> clazz) {
		
		return true;
	}

	// 加载所有资源与权限的关系
	private void loadResourceDefine() {
		if (resourceMap == null) {

			resourceMap = new HashMap<String, Collection<ConfigAttribute>>();

			List<Resource> resources = this.resourceDao.findAll();
			for (Resource resource : resources) {
				Collection<ConfigAttribute> configAttributes = new ArrayList<ConfigAttribute>();
				// 以权限名封装为Spring的security Object
				ConfigAttribute configAttribute = new SecurityConfig(
						resource.getName());
				configAttributes.add(configAttribute);
				resourceMap.put(resource.getUrl(), configAttributes);
			}

		}

		Set<Entry<String, Collection<ConfigAttribute>>> resourceSet = resourceMap.entrySet();
		Iterator<Entry<String, Collection<ConfigAttribute>>> iterator = resourceSet.iterator();

	}

	// 返回所请求资源所需要的权限
	@Transactional
	public Collection<ConfigAttribute> getAttributes(Object object)
			throws IllegalArgumentException {

		String requestUrl = ((FilterInvocation) object).getRequestUrl();
		System.out.println("requestUrl is " + requestUrl);
		if (resourceMap == null) {
			loadResourceDefine();
		}
		return resourceMap.get(requestUrl);
	}

}