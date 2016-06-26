package com.seri.security;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import com.seri.service.notification.RoleType;
 
@Entity
@Table(name="ROLES")
public class Role implements GrantedAuthority {
	
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="ID")
    private long id;
    
    @Column(name="ROLE")
    @Enumerated(EnumType.STRING)
    private RoleType roleName;
    
//    @OneToOne(mappedBy="primaryKey.role", cascade=CascadeType.ALL)
//    private UseruserRoles = new ArrayList<UserRoles>();
    
    @OneToMany(cascade=CascadeType.ALL)
    @JoinTable(name="ROLES_PREVILEGES", joinColumns={@JoinColumn(name="ROLE")},inverseJoinColumns={@JoinColumn(name="PRIVILEGE")})
    private List<Privilege> privileges;
    
 
    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

    public RoleType getRoleName() {
		return roleName;
	}

	public void setRoleName(RoleType roleName) {
		this.roleName = roleName;
	}

	@Override
    public String getAuthority() {
        return this.roleName.toString();
    }
 
    public List<Privilege> getPrivileges() {
        return privileges;
    }
 
    public void setPrivileges(List<Privilege> privileges) {
        this.privileges = privileges;
    }
    
//	public List<UserRoles> getUserRoles() {
//		return userRoles;
//	}
//
//	public void setUserRoles(List<UserRoles> userRoles) {
//		this.userRoles = userRoles;
//	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", roleName=" + roleName + ", privileges=" + privileges + "]";
	}
	
	
    
}