package com.lx.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.lx.web.dao.UserDao;
import com.lx.web.model.Resource;
import com.lx.web.model.Role;


public class LXUserDetailServiceImpl implements UserDetailsService {

	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	@Transactional
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		System.out.println("username is " + username);
		com.lx.web.model.User users = this.userDao.findByName(username);
		if (users == null) {
			throw new UsernameNotFoundException(username);
		}
		Collection<GrantedAuthority> grantedAuths = obtionGrantedAuthorities(users);

		boolean enables = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;

		UserDetails userdetail = new User(users.getUsername(),
				users.getPassword(), enables, accountNonExpired,
				credentialsNonExpired, accountNonLocked, grantedAuths);
		return userdetail;
	}

	// 取得用户的权限
	private Set<GrantedAuthority> obtionGrantedAuthorities(com.lx.web.model.User user) {
		Set<GrantedAuthority> authSet = new HashSet<GrantedAuthority>();
		Set<Role> roles = user.getRoles();

		for (Role role : roles) {
			Set<Resource> tempRes = role.getResources();
			for (Resource res : tempRes) {
				authSet.add(new GrantedAuthorityImpl(res.getName()));
			}
		}
		return authSet;
	}

}