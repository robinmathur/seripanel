package com.seri.web.model;

import java.io.Serializable;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import com.seri.security.Role;


@Entity
@Table(name = "USERS_ROLES")
@AssociationOverrides({
    @AssociationOverride(name = "primaryKey.user",
        joinColumns = @JoinColumn(name = "USER")),
    @AssociationOverride(name = "primaryKey.role",
        joinColumns = @JoinColumn(name = "ROLE")) })
public class UserRoles  implements Serializable{
	
	@EmbeddedId
	private UserRoleId primaryKey = new UserRoleId();
	
	@Column(name="IS_DEFAULT")
	private boolean isDefault = true;
	
	public User getUser() {
		return primaryKey.getUser();
	}
	public Role getRole() {
		return primaryKey.getRole();
	}
	public void setUser(User user) {
		this.primaryKey.setUser(user);
	}
	public void setRole(Role role) {
		this.primaryKey.setRole(role);
	}

	public UserRoleId getPrimaryKey() {
		return primaryKey;
	}

	public boolean isDefault() {
		return isDefault;
	}

	public void setPrimaryKey(UserRoleId primaryKey) {
		this.primaryKey = primaryKey;
	}

	public void setDefault(boolean isDefault) {
		this.isDefault = isDefault;
	}
	
	

}
