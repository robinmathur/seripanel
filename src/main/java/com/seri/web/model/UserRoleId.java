package com.seri.web.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.seri.security.Role;

@Embeddable
public class UserRoleId implements Serializable{

	@ManyToOne(cascade=CascadeType.ALL)
	private User user;
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="ROLE")
	private Role role = new Role();
	public User getUser() {
		return user;
	}
	public Role getRole() {
		return role;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
}
