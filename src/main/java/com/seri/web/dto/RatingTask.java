package com.seri.web.dto;

public class RatingTask {
	
	private int studenID;
	private String studentName;
	private long rateId;
	private int rate;
	private int outOf;
	private String content;
	private String taskType;
	private String comment;
	private long syllabusId;
	
	public RatingTask(){};
	
	
	public RatingTask(int studenID, String studentName, long rateId, int rate, int outOf, String content, String taskType, String comment, long syllabusId) {
		super();
		this.studenID = studenID;
		this.studentName = studentName;
		this.rateId = rateId;
		this.rate = rate;
		this.outOf = outOf;
		this.content = content;
		this.taskType =taskType;
		this.comment = comment;
		this.syllabusId = syllabusId;
	}


	public int getStudenID() {
		return studenID;
	}
	public String getStudentName() {
		return studentName;
	}
	public long getRateId() {
		return rateId;
	}
	public int getRate() {
		return rate;
	}
	public int getOutOf() {
		return outOf;
	}
	public String getContent() {
		return content;
	}
	public void setStudenID(int studenID) {
		this.studenID = studenID;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public void setRateId(long rateId) {
		this.rateId = rateId;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	public void setOutOf(int outOf) {
		this.outOf = outOf;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public String getTaskType() {
		return taskType;
	}

	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}


	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}


	public long getSyllabusId() {
		return syllabusId;
	}

	public void setSyllabusId(long syllabusId) {
		this.syllabusId = syllabusId;
	}
	
}
