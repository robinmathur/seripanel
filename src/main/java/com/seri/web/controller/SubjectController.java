package com.seri.web.controller;

import com.seri.web.dao.SubjectDao;
import com.seri.web.dao.UserDao;
import com.seri.web.dao.daoImpl.SubjectDaoImpl;
import com.seri.web.dao.daoImpl.UserDaoImpl;
import com.seri.web.model.School;
import com.seri.web.model.Standard;
import com.seri.web.model.Subject;
import com.seri.web.model.User;
import com.seri.web.utils.GlobalFunUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by puneet on 29/05/16.
 */
@Controller
@RequestMapping(value = "subject")
public class SubjectController {

    private GlobalFunUtils globalFunUtils = new GlobalFunUtils();
    private UserDao userDao = new UserDaoImpl();
    private SubjectDao subjectDao = new SubjectDaoImpl();

    @RequestMapping(value = "/addsubject/", method = RequestMethod.GET)
    public @ResponseBody
    String addSubject(HttpServletRequest request) {
        try {
            String name = request.getParameter("name");
            int standardId = Integer.parseInt(request.getParameter("standardId"));
            int isCompulsary = Integer.parseInt(request.getParameter("isCompulsary"));
            int status = Integer.parseInt(request.getParameter("status"));
            User sessUser = globalFunUtils.getLoggedInUserDetail();
            String dateTime = globalFunUtils.getDateTime();

            Subject subject = new Subject();
            subject.setIsCompulsary(isCompulsary);
            subject.setStandardId(standardId);
            subject.setSubjectName(name);
            subject.setStatus(status);
            subject.setCreatedBy(sessUser.getLogin());
            subject.setCreatedDate(dateTime);
            subject.setLastUpdatedBy(sessUser.getLogin());
            subject.setLastUpdatedDate(dateTime);
            subject.setEntityName("subject");

            if(request.getParameter("subjectId") != null) {
                subject.setSubjectId(Integer.parseInt(request.getParameter("subjectId")));
                subjectDao.update(subject);
            }
            else
                subjectDao.create(subject);
            return String.valueOf(subject.getSubjectId());

        } catch (Exception e) {
            return "false";
        }
    }

    @RequestMapping(value = "/subjectlisting/", method = RequestMethod.GET)
    public @ResponseBody
    String getSubjectListing(HttpServletRequest request) {
        try {
            if(request.getParameter("standardId")==null)
                return "<tr><td colspan='3'><h4>No Subject Found</h4></td>";
            int standardId = Integer.parseInt(request.getParameter("standardId"));
            List<Subject> subjectList = subjectDao.getSubjectByStandardId(standardId);
            String retHtml = "";
            if(subjectList != null) {
                for (Subject subject:subjectList) {
                    retHtml+= "<tr><td></td><td>"+subject.getSubjectName()+"</td>" +
                            "<td><a href='#moduleModalForm' data-sub-id='"+subject.getSubjectId()+"' data-standard-id='"+subject.getStandardId()+"' class='sub-edit-a module-modal-btn' data-toggle='modal'>Manage Module</a>" +
                            "<td><a href='#standardAddForm' data-sub-id='"+subject.getSubjectId()+"' data-standard-id='"+subject.getStandardId()+"' class='sub-edit-a' data-toggle='modal'><i class='icon-edit'></i></a></td></tr>";
                }

            } else {
                return "<tr><td colspan='3'><h4>No Subject Found</h4></td>";
            }
            return retHtml;
        } catch (Exception e) {
            return "<tr><td colspan='3'><h4>No Subject Found</h4></td>";
        }
    }

    @RequestMapping(value = "/getschoolsubjects/", method = RequestMethod.GET)
    public @ResponseBody
    String getSchoolSubjectCtrl(HttpServletRequest request) {
        String ctrlName  = request.getParameter("ctrlName");
        String ctrlId  = request.getParameter("ctrlId");
        String ctrlClass  = request.getParameter("ctrlClass");
        int selectedSubject = Integer.parseInt(request.getParameter("selectedSubjectVal"));

        if(ctrlName==null)
            ctrlClass="subs_standard";
        if(ctrlId==null)
            ctrlId = ctrlClass;
        if(ctrlClass==null)
            ctrlClass=ctrlName;

        String retHtml = "<select name='"+ctrlName+"' class='"+ctrlClass+"' id='"+ctrlId+"'><option value='0'>--Select Subject--</option>";

        try {
            if(request.getParameter("standardId")==null)
                throw new Exception();
            int standardId = Integer.parseInt(request.getParameter("standardId"));



            List<Subject> subjectList = subjectDao.getSubjectByStandardId(standardId);
            if(subjectList != null) {
                for (Subject subject:subjectList) {
                    retHtml+= "<option value='"+subject.getSubjectId()+"' " + ((subject.getSubjectId()==selectedSubject) ? "selected='selected'" : "") +">"+subject.getSubjectName()+"</option>";
                }

            } else {
                throw new Exception();
            }
            return retHtml;
        } catch (Exception e) { }

        retHtml+= "</select>";
        return retHtml;
    }

    @RequestMapping(value = "/getsubjectmodules/", method = RequestMethod.GET)
    public @ResponseBody
    String getSubjectModuleCtrl(HttpServletRequest request) {
        String ctrlName  = request.getParameter("ctrlName");
        String ctrlId  = request.getParameter("ctrlId");
        String ctrlClass  = request.getParameter("ctrlClass");
        int selectedModule = Integer.parseInt(request.getParameter("selectedModuleVal"));

        if(ctrlName==null)
            ctrlClass="sub_modules";
        if(ctrlId==null)
            ctrlId = ctrlClass;
        if(ctrlClass==null)
            ctrlClass=ctrlName;

        String retHtml = "<select name='"+ctrlName+"' class='"+ctrlClass+"' id='"+ctrlId+"'><option value='0'>--Select Module--</option>";

        try {
            if(request.getParameter("subjectId")==null)
                throw new Exception();
            int subjectId = Integer.parseInt(request.getParameter("subjectId"));



            List<Subject> subjectList = subjectDao.getModuleListByPid(subjectId);
            if(subjectList != null) {
                for (Subject subject:subjectList) {
                    retHtml+= "<option value='"+subject.getSubjectId()+"' " + ((subject.getSubjectId()==selectedModule) ? "selected='selected'" : "") +">"+subject.getSubjectName()+"</option>";
                }

            } else {
                throw new Exception();
            }
            return retHtml;
        } catch (Exception e) { }

        retHtml+= "</select>";
        return retHtml;
    }

    @RequestMapping(value = "/addmodule/", method = RequestMethod.POST)
    public @ResponseBody
    String addModuleFunction(@ModelAttribute("subjectForm") Subject subject, HttpServletRequest request) {
        String dateTime = globalFunUtils.getDateTime();
        User sessUser = globalFunUtils.getLoggedInUserDetail();
        subject.setIsCompulsary(1);
        subject.setStatus(1);
        subject.setCreatedDate(dateTime);
        subject.setCreatedBy(sessUser.getLogin());
        subject.setLastUpdatedBy(sessUser.getLogin());
        subject.setLastUpdatedDate(dateTime);
        subjectDao.create(subject);
        return String.valueOf(subject.getSubjectId());
    }

    @RequestMapping(value = "/editmodule/", method = RequestMethod.POST)
    public @ResponseBody
    String editModuleFunction(@ModelAttribute("subjectForm") Subject moduleForm, HttpServletRequest request) {
        String dateTime = globalFunUtils.getDateTime();
        User sessUser = globalFunUtils.getLoggedInUserDetail();
        Subject module = subjectDao.getSubjectBySubjectId(moduleForm.getSubjectId());
        module.setSubjectName(moduleForm.getSubjectName());
        module.setLastUpdatedBy(sessUser.getLogin());
        module.setLastUpdatedDate(dateTime);
        subjectDao.update(module);
        return String.valueOf(module.getSubjectId());
    }

    @RequestMapping(value = "/modulelisting/", method = RequestMethod.GET)
    public @ResponseBody
    String getModuleListing(HttpServletRequest request) {
        try {
            if(request.getParameter("pid")==null)
                return "<tr><td colspan='3'><h4>No Module Found</h4></td>";
            int pid = Integer.parseInt(request.getParameter("pid"));
            List<Subject> moduleList = subjectDao.getModuleListByPid(pid);
            String retHtml = "";
            if(moduleList != null) {
                for (Subject module:moduleList) {
                    retHtml+= "<tr><td></td><td>"+module.getSubjectName()+"</td>" +
                            "<td><a href='#' data-id='"+module.getSubjectId()+"' data-standard-id='"+module.getStandardId()+"' class='editModuleA'><i class='icon-edit'></i></a></td></tr>";
                }

            } else {
                return "<tr><td colspan='3'><h4>No Module Found</h4></td>";
            }
            return retHtml;
        } catch (Exception e) {
            return "<tr><td colspan='3'><h4>No Module Found</h4></td>";
        }
    }
}
