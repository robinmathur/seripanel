package com.seri.service.rating;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.seri.common.BaseEntity;
import com.seri.common.CommonTypes;

@Entity
@Table(name = "RATING")
public class Rating extends BaseEntity {

	
	@Column(name = "ENTITY")
	private long entityId;
	@Column(name = "RATE_TYPE")
	@Enumerated(EnumType.STRING)
	private CommonTypes ratingType;
	@Column(name = "RATE")
	private int rate;
	@Column(name = "OUTOF")
	private int outof;
	@Column(name = "SCHOOL")
	private long schoolId;
	@Column(name = "STANDARD")
	private long standardId;
	@Column(name = "MODULE")
	private long moduleId;
	@Column(name = "COMMENT")
	private String comment;

	public int getRate() {
		return rate;
	}

	public int getOutof() {
		return outof;
	}

	public String getComment() {
		return comment;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public void setOutof(int outof) {
		this.outof = outof;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public long getSchoolId() {
		return schoolId;
	}

	public long getStandardId() {
		return standardId;
	}

	public long getModuleId() {
		return moduleId;
	}

	public void setSchoolId(long schoolId) {
		this.schoolId = schoolId;
	}

	public void setStandardId(long standardId) {
		this.standardId = standardId;
	}

	public void setModuleId(long moduleId) {
		this.moduleId = moduleId;
	}

	public CommonTypes getRatingType() {
		return ratingType;
	}

	public void setRatingType(CommonTypes ratingType) {
		this.ratingType = ratingType;
	}
	

	public long getEntityId() {
		return entityId;
	}

	public void setEntityId(long entityId) {
		this.entityId = entityId;
	}

	@Override
	public String toString() {
		return "Rating [rate=" + rate + ", outof=" + outof + ", schoolId=" + schoolId + ", standardId=" + standardId
				+ ", moduleId=" + moduleId + ", comment=" + comment + "]";
	}

}
