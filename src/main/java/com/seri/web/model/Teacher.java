package com.seri.web.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * Created by puneet on 07/04/16.
 */
@Entity
@Table(name = "TEACHER_PROFILE")
public class Teacher implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "TEACHER_ID")
    private int teacherId;

    @Column(name = "EMAIL")
    private String email;
    @Column(name = "TEACHER_SCHOOL_ID")
    private int teacherSchoolId;
    @Column(name = "STANDARD_ID")
    private String teacherStandardId;

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
    private String gender;

    @Column(name = "t_mob_no")
    private String tMobNo;
    @Column(name = "t_login_id")
    private long tLoginId;
    @Column(name = "t_ph_no")
    private String tPhNo;
    @Column(name = "t_description")
    private String tDescription;
    @Column(name = "t_nationality")
    private String tNationality;
    @Column(name = "t_personal_email")
    private String tPersonalEmail;
    @Column(name = "t_home_adress")
    private String tHomeAdress;
    @Column(name = "t_experiance")
    private float tExperiance;
    @Column(name = "t_sec_marks")
    private float tSecMarks;
    @Column(name = "t_sen_sec_marks")
    private float tSenSecMarks;
    @Column(name = "t_grad_metadata")
    private String tGradMetadata;
    @Column(name = "t_pg_metadata")
    private String tPgMetadata;
    @Column(name = "t_oth_qualification_metadata")
    private String tOthQualificationMetadata;
    @Column(name = "t_category")
    private String tCategory;
    @Column(name = "t_specialization")
    private String tSpecialization;
    @Column(name = "t_oth_specialization")
    private String tOthSpecialization;
    @Column(name = "t_dept_name")
    private int tDeptName;
    @Column(name = "t_designation")
    private String tDesignation;
    @Column(name = "t_oth_skills")
    private String tOthSkills;
    @Column(name = "t_joining_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date tJoiningDate;
    @Column(name = "t_lang_speak")
    private String tLangSpeak;
    @Column(name = "t_lang_write")
    private String tLangWrite;
    @Column(name = "t_oth_lang")
    private String tOthLang;
    @Column(name = "t_ref_1_metadata")
    private String tRef1Metadata;
    @Column(name = "t_ref_2_metadata")
    private String tRef2Metadata;
    @Column(name = "t_last_org_metadata")
    private String tLastOrgMetadata;
    @Column(name = "t_created_date")
    private Date tCreatedDate;
    @Column(name = "t_created_by")
    private long tCreatedBy;
    @Column(name = "t_last_update_date")
    private Date tLastUpdateDate;
    @Column(name = "t_last_update_by")
    private long tLastUpdateBy;

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTeacherSchoolId() {
        return teacherSchoolId;
    }

    public void setTeacherSchoolId(int teacherSchoolId) {
        this.teacherSchoolId = teacherSchoolId;
    }

    public String getTeacherStandardId() {
        return teacherStandardId;
    }

    public void setTeacherStandardId(String teacherStandardId) {
        this.teacherStandardId = teacherStandardId;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String gettMobNo() {
        return tMobNo;
    }

    public void settMobNo(String tMobNo) {
        this.tMobNo = tMobNo;
    }

    public long gettLoginId() {
        return tLoginId;
    }

    public void settLoginId(long tLoginId) {
        this.tLoginId = tLoginId;
    }

    public String gettPhNo() {
        return tPhNo;
    }

    public void settPhNo(String tPhNo) {
        this.tPhNo = tPhNo;
    }

    public String gettDescription() {
        return tDescription;
    }

    public void settDescription(String tDescription) {
        this.tDescription = tDescription;
    }

    public String gettNationality() {
        return tNationality;
    }

    public void settNationality(String tNationality) {
        this.tNationality = tNationality;
    }

    public String gettPersonalEmail() {
        return tPersonalEmail;
    }

    public void settPersonalEmail(String tPersonalEmail) {
        this.tPersonalEmail = tPersonalEmail;
    }

    public String gettHomeAdress() {
        return tHomeAdress;
    }

    public void settHomeAdress(String tHomeAdress) {
        this.tHomeAdress = tHomeAdress;
    }

    public float gettExperiance() {
        return tExperiance;
    }

    public void settExperiance(float tExperiance) {
        this.tExperiance = tExperiance;
    }

    public float gettSecMarks() {
        return tSecMarks;
    }

    public void settSecMarks(float tSecMarks) {
        this.tSecMarks = tSecMarks;
    }

    public float gettSenSecMarks() {
        return tSenSecMarks;
    }

    public void settSenSecMarks(float tSenSecMarks) {
        this.tSenSecMarks = tSenSecMarks;
    }

    public String gettGradMetadata() {
        return tGradMetadata;
    }

    public void settGradMetadata(String tGradMetadata) {
        this.tGradMetadata = tGradMetadata;
    }

    public String gettPgMetadata() {
        return tPgMetadata;
    }

    public void settPgMetadata(String tPgMetadata) {
        this.tPgMetadata = tPgMetadata;
    }

    public String gettOthQualificationMetadata() {
        return tOthQualificationMetadata;
    }

    public void settOthQualificationMetadata(String tOthQualificationMetadata) {
        this.tOthQualificationMetadata = tOthQualificationMetadata;
    }

    public String gettCategory() {
        return tCategory;
    }

    public void settCategory(String tCategory) {
        this.tCategory = tCategory;
    }

    public String gettSpecialization() {
        return tSpecialization;
    }

    public void settSpecialization(String tSpecialization) {
        this.tSpecialization = tSpecialization;
    }

    public String gettOthSpecialization() {
        return tOthSpecialization;
    }

    public void settOthSpecialization(String tOthSpecialization) {
        this.tOthSpecialization = tOthSpecialization;
    }

    public int gettDeptName() {
        return tDeptName;
    }

    public void settDeptName(int tDeptName) {
        this.tDeptName = tDeptName;
    }

    public String gettDesignation() {
        return tDesignation;
    }

    public void settDesignation(String tDesignation) {
        this.tDesignation = tDesignation;
    }

    public String gettOthSkills() {
        return tOthSkills;
    }

    public void settOthSkills(String tOthSkills) {
        this.tOthSkills = tOthSkills;
    }

    public Date gettJoiningDate() {
        return tJoiningDate;
    }

    public void settJoiningDate(Date tJoiningDate) {
        this.tJoiningDate = tJoiningDate;
    }

    public String gettLangSpeak() {
        return tLangSpeak;
    }

    public void settLangSpeak(String tLangSpeak) {
        this.tLangSpeak = tLangSpeak;
    }

    public String gettLangWrite() {
        return tLangWrite;
    }

    public void settLangWrite(String tLangWrite) {
        this.tLangWrite = tLangWrite;
    }

    public String gettOthLang() {
        return tOthLang;
    }

    public void settOthLang(String tOthLang) {
        this.tOthLang = tOthLang;
    }

    public String gettRef1Metadata() {
        return tRef1Metadata;
    }

    public void settRef1Metadata(String tRef1Metadata) {
        this.tRef1Metadata = tRef1Metadata;
    }

    public String gettRef2Metadata() {
        return tRef2Metadata;
    }

    public void settRef2Metadata(String tRef2Metadata) {
        this.tRef2Metadata = tRef2Metadata;
    }

    public String gettLastOrgMetadata() {
        return tLastOrgMetadata;
    }

    public void settLastOrgMetadata(String tLastOrgMetadata) {
        this.tLastOrgMetadata = tLastOrgMetadata;
    }

    public Date gettCreatedDate() {
        return tCreatedDate;
    }

    public void settCreatedDate(Date tCreatedDate) {
        this.tCreatedDate = tCreatedDate;
    }

    public long gettCreatedBy() {
        return tCreatedBy;
    }

    public void settCreatedBy(long tCreatedBy) {
        this.tCreatedBy = tCreatedBy;
    }

    public Date gettLastUpdateDate() {
        return tLastUpdateDate;
    }

    public void settLastUpdateDate(Date tLastUpdateDate) {
        this.tLastUpdateDate = tLastUpdateDate;
    }

    public long gettLastUpdateBy() {
        return tLastUpdateBy;
    }

    public void settLastUpdateBy(long tLastUpdateBy) {
        this.tLastUpdateBy = tLastUpdateBy;
    }
}
