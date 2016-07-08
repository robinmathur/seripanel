package com.seri.web.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.seri.common.BaseEntity;
import com.seri.common.Gender;
import com.seri.security.Role;
import com.seri.service.notification.RoleType;

/**
 * Created by puneet on 03/04/16.
 */
@Entity
@Table(name = "USER")
public class User extends BaseEntity implements UserDetails {
    
	private static final long serialVersionUID = 1L;
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "EMAIL")
    private String email;
//    @Column(name = "ROLE")
//    private String role;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "F_NAME")
    private String fName;
    @Column(name = "M_NAME")
    private String mName;
    @Column(name = "L_NAME")
    private String lName;
    @Column(name = "DOB")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dob;
    @Column(name = "PHOTO")
    private String photo;
    @Column(name = "GENDER")
    @Enumerated(EnumType.STRING)
    private Gender gender;
//    @Column(name = "STATUS")
//    private int status;
    @Column(name = "PASSWORD_TOKEN")
    private String passwordToken;
    @Column(name = "FIRST_RESET")
    private int firstReset;
    @Column(name = "SCHOOL")
    private int school;
    @Column(name = "STANDARD")
    private String standard;
    
    @Transient
    private List<Role> authorities;
    @Transient
    private Role defaultRole;
    @Transient
    private List<RoleType> roleTypeList;
    
    
    @Column(name = "ACCOUNT_NON_EXPIRED")
    private boolean accountNonExpired = true;
    @Column(name = "ACCOUNT_NOT_LOCKED")
    private boolean accountNonLocked = true;
    @Column(name = "CREDENTIALS_NON_EXPIRED")
    private boolean credentialsNonExpired = true;
    @Column(name = "ENABLED")
    private boolean enabled = true;
    
    @OneToMany(mappedBy="primaryKey.user", cascade=CascadeType.ALL)
    private List<UserRoles> userRoles = new ArrayList<UserRoles>();

    
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if(null == authorities){
			List<Role> authorities  = new ArrayList<Role>();
			for(UserRoles userRole : userRoles){
				authorities.add(userRole.getRole());
			}
		}
		return authorities;
	}
	
	public Role getDefaultRole(){
		if(null == defaultRole){
			for(UserRoles userRole : userRoles){
				if(userRole.isDefault())
					defaultRole=userRole.getRole();
			}
		}
		return defaultRole;
	}
	
	public List<RoleType> getRoleTypeList(){
		if(null == roleTypeList){
			roleTypeList = new ArrayList<RoleType>();
			for(UserRoles userRole : userRoles){
				roleTypeList.add(userRole.getRole().getRoleName());
			}
		}
		return roleTypeList;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

	public String getPassword() {
		return password;
	}

	public String getfName() {
		return fName;
	}

	public String getmName() {
		return mName;
	}

	public String getlName() {
		return lName;
	}

	public Date getDob() {
		return dob;
	}

	public String getPhoto() {
		return photo;
	}

	public Gender getGender() {
		return gender;
	}

	public String getPasswordToken() {
		return passwordToken;
	}

	public int getFirstReset() {
		return firstReset;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public void setPasswordToken(String passwordToken) {
		this.passwordToken = passwordToken;
	}

	public void setFirstReset(int firstReset) {
		this.firstReset = firstReset;
	}

	public void setAuthorities(List<Role> authorities) {
		this.authorities = authorities;
	}

	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean getEnabled() {
		return enabled;
	}
	public int getSchool() {
		return school;
	}

	public String getStandard() {
		return standard;
	}

	public void setSchool(int school) {
		this.school = school;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public List<UserRoles> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<UserRoles> userRoles) {
		this.userRoles = userRoles;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", email=" + email + ", password=" + password + ", fName=" + fName
				+ ", mName=" + mName + ", lName=" + lName + ", dob=" + dob + ", photo=" + photo + ", gender=" + gender
				+ ", passwordToken=" + passwordToken + ", firstReset=" + firstReset + ", school=" + school
				+ ", standard=" + standard + ", authorities=" + authorities + ", defaultRole=" + defaultRole
				+ ", roleTypeList=" + roleTypeList + ", accountNonExpired=" + accountNonExpired + ", accountNonLocked="
				+ accountNonLocked + ", credentialsNonExpired=" + credentialsNonExpired + ", enabled=" + enabled
				+ ", userRoles=" + userRoles + "]";
	}
	
	
	
}
