package com.seri.security;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PREVILEGES")
public class Privilege  implements Serializable{
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="ID")
	private long id;
	@Column(name="PREVILEGE")
	private String name;
	
    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }

	@Override
	public String toString() {
		return "Privilege [id=" + id + ", name=" + name + "]";
	}
 
}