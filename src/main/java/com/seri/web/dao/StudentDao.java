package com.seri.web.dao;

import java.util.List;
import java.util.Map;

import com.seri.web.model.Student;

/**
 * Created by puneet on 28/04/16.
 */
public interface StudentDao {

    public boolean create(Student student);

    public boolean update(Student student);

    public Student getStudentUsingStudentId(long id);

    public Student getStudentUsingStudentLogin(long login);

    public List<Student> getStudentListUsingSchoolId(int schoolId);

    public List<Student> getStudentWithoutParentProfile();

    public List<Student> getStudentListUsingSchoolId(Map<String, Integer> params, boolean count);

    List<Student> getStudentListUsingFilters(Map<String, Integer> params, boolean count);
}
