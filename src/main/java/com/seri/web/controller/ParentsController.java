package com.seri.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.seri.web.utils.GlobalFunUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.seri.service.notification.RoleType;
import com.seri.web.dao.HodDao;
import com.seri.web.dao.ParentsDao;
import com.seri.web.dao.SchoolDao;
import com.seri.web.dao.StudentDao;
import com.seri.web.dao.SubjectDao;
import com.seri.web.dao.UserDao;
import com.seri.web.dao.daoImpl.HodDaoImpl;
import com.seri.web.dao.daoImpl.ParentsDaoImpl;
import com.seri.web.dao.daoImpl.SchoolDaoImpl;
import com.seri.web.dao.daoImpl.StudentDaoImpl;
import com.seri.web.dao.daoImpl.SubjectDaoImpl;
import com.seri.web.dao.daoImpl.UserDaoImpl;
import com.seri.web.model.Parents;
import com.seri.web.model.School;
import com.seri.web.model.Student;
import com.seri.web.model.Subject;
import com.seri.web.model.User;
import com.seri.web.utils.LoggedUserUtil;

/**
 * Created by puneet on 28/05/16.
 */
@Controller
@RequestMapping(value = "parent")
public class ParentsController {

    private ParentsDao parentsDao = new ParentsDaoImpl();
    private StudentDao studentDao = new StudentDaoImpl();
    private SchoolDao schoolDao = new SchoolDaoImpl();
    private HodDao hodDao = new HodDaoImpl();
    private UserDao userDao = new UserDaoImpl();
    private SubjectDao subjectDao = new SubjectDaoImpl();

    @Autowired
    private GlobalFunUtils globalFunUtils;

    @RequestMapping(value = "/update**", method = RequestMethod.GET)
    public ModelAndView updateParent(HttpServletRequest request) {
        ModelAndView model = new ModelAndView();
        globalFunUtils.getNotification(model);
        if(request.getParameter("id") == null)
            return new ModelAndView("redirect:manage_student");

        int id = Integer.parseInt(request.getParameter("id"));

        Parents parentsProfile = parentsDao.getProfileUsingParentsId(id);
        if(parentsProfile==null)
            return new ModelAndView("redirect:manage_student");

        Student student = studentDao.getStudentUsingStudentId(parentsProfile.getStudentId());

        if(LoggedUserUtil.hasRole(RoleType.ROLE_SCHOOL_ADMIN)) {
            School tempSchool = schoolDao.getSchoolUsingPrincipal(LoggedUserUtil.getUserId());
            if(student==null || tempSchool.getSchoolId()!=student.getStuSchoolId()) {
                return new ModelAndView("redirect:manage_student");
            }
        }

        User userForm = userDao.getUserUsingEmail(parentsProfile.getEmail());

        model.addObject("userForm", userForm);
        model.addObject("parentsForm", parentsProfile);
        model.addObject("formAction", "parentUpdate");

        model.setViewName("parent/parent_update");
        return model;
    }

    @RequestMapping(value = "/dashboard**", method = RequestMethod.GET)
    public ModelAndView dashboardPage(HttpServletRequest request) {
        ModelAndView model = new ModelAndView();
        globalFunUtils.getNotification(model);
        Parents parents = parentsDao.getProfileUsingLoginId(LoggedUserUtil.getUserId());
        Student student = studentDao.getStudentUsingStudentId(parents.getStudentId());
        List<Subject> subjectList = subjectDao.getSubjectByStandardId(student.getStuStandardId());
        model.addObject("subjectList", subjectList);
        model.setViewName("parent/dashboard");
        return model;
    }
}
