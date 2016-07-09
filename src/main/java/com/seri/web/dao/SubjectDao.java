package com.seri.web.dao;

import java.util.List;

import com.seri.web.model.Subject;

/**
 * Created by puneet on 29/05/16.
 */
public interface SubjectDao {

    public Boolean create(Subject subject);

    public Boolean update(Subject subject);

    public Subject getSubjectBySubjectId(long id);

    public List<Subject> getSubjectByStandardId(int id);

    public List<Subject> getSubjectByCompulsary(int flag);

    public Subject getSubjectByName(String name);

    public List<Subject> getModuleListByPid(int id);

    public List<Subject> getSubjectListUsingInId(String ids);
}
