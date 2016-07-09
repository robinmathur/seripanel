package com.seri.common;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

//@Entity
//@Table(name="ENTITY_TABLE")
//@Inheritance(strategy=InheritanceType.JOINED)
@MappedSuperclass
public abstract class BaseEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	protected long id;
	@Column(name = "CREATED_BY")
	protected long createdBy;
    @Column(name = "CREATED_DATE")
    protected Date createdDate;
    @Column(name = "LAST_UPDATED_BY")
    protected long lastUpdatedBy;
    @Column(name = "LAST_UPDATED_DATE")
    protected Date lastUpdatedDate;
//    @Column(name = "ROLE")
//    @Enumerated(EnumType.STRING)
//    private Roles entityRole; 
    
	public long getId() {
		return id;
	}
	public long getCreatedBy() {
		return createdBy;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public long getLastUpdatedBy() {
		return lastUpdatedBy;
	}
	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setCreatedBy(long createdBy) {
		this.createdBy = createdBy;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public void setLastUpdatedBy(long lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}
	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}
	
	
	/*public Roles getEntityRole() {
		return entityRole;
	}
	public void setEntityRole(Roles entityRole) {
		this.entityRole = entityRole;
	}*/
	@Override
	public String toString() {
		return "BaseEntity [id=" + id + ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", lastUpdatedBy="
				+ lastUpdatedBy + ", lastUpdatedDate=" + lastUpdatedDate + "]";
	}
    
}
