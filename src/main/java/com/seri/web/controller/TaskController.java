package com.seri.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.seri.web.dao.HodDao;
import com.seri.web.dao.ParentsDao;
import com.seri.web.dao.SchoolDao;
import com.seri.web.dao.StandardDao;
import com.seri.web.dao.StudentDao;
import com.seri.web.dao.SubjectDao;
import com.seri.web.dao.SyllabusDao;
import com.seri.web.dao.TeacherDao;
import com.seri.web.dao.UserDao;
import com.seri.web.dao.daoImpl.HodDaoImpl;
import com.seri.web.dao.daoImpl.ParentsDaoImpl;
import com.seri.web.dao.daoImpl.SchoolDaoImpl;
import com.seri.web.dao.daoImpl.StandardDaoImpl;
import com.seri.web.dao.daoImpl.StudentDaoImpl;
import com.seri.web.dao.daoImpl.SubjectDaoImpl;
import com.seri.web.dao.daoImpl.SyllabusDaoImpl;
import com.seri.web.dao.daoImpl.TeacherDaoImpl;
import com.seri.web.dao.daoImpl.UserDaoImpl;
import com.seri.web.model.Hod;
import com.seri.web.model.Parents;
import com.seri.web.model.School;
import com.seri.web.model.Student;
import com.seri.web.model.Subject;
import com.seri.web.model.Syllabus;
import com.seri.web.model.Teacher;
import com.seri.web.model.User;
import com.seri.web.utils.GlobalFunUtils;

/**
 * Created by puneet on 11/06/16.
 */
@Controller
@RequestMapping(value = "tasks")
public class TaskController {

    private GlobalFunUtils globalFunUtils = new GlobalFunUtils();
    private SchoolDao schoolDao = new SchoolDaoImpl();
    private UserDao userDao = new UserDaoImpl();
    private SyllabusDao syllabusDao = new SyllabusDaoImpl();
    private StandardDao standardDao = new StandardDaoImpl();
    private HodDao hodDao = new HodDaoImpl();
    private TeacherDao teacherDao = new TeacherDaoImpl();
    private StudentDao studentDao = new StudentDaoImpl();
    private SubjectDao subjectDao = new SubjectDaoImpl();
    private ParentsDao parentsDao = new ParentsDaoImpl();

    @RequestMapping(value = "/content**", method = RequestMethod.GET)
    public ModelAndView manageStudentPage(HttpServletRequest request) {
        try {
            ModelAndView model = new ModelAndView();
            User sessUser = globalFunUtils.getLoggedInUserDetail();
            int schoolId = 0;
            int standardId = 0;
            int subjectId = 0;
            int moduleId = 0;
            String taskName="";
            if (sessUser.getRole().equals("ROLE_TEACHER")) {
                Teacher teacher = teacherDao.getTeacherUsingLoginId(sessUser.getUserId());
                schoolId = teacher.getTeacherSchoolId();
                String tempStandardId = teacher.getTeacherStandardId();
                tempStandardId = tempStandardId.substring(1, tempStandardId.length() - 1);
                if (request.getParameter("standardid") != null){
                    standardId = Integer.parseInt(request.getParameter("standardid"));
                }
                model.addObject("tempStandardId", tempStandardId);
            } else if (sessUser.getRole().equals("ROLE_HOD")) {

            } else if (sessUser.getRole().equals("ROLE_SCHOOL_ADMIN")) {
                if (request.getParameter("standardid") != null){
                    standardId = Integer.parseInt(request.getParameter("standardid"));
                }
                School school = schoolDao.getSchoolUsingPrincipalEmail(sessUser.getLogin());
                schoolId = school.getSchoolId();

            } else if (sessUser.getRole().equals("ROLE_SUP_ADMIN")) {
                if (request.getParameter("standardid") != null){
                    standardId = Integer.parseInt(request.getParameter("standardid"));
                }
                if (request.getParameter("schoolid") != null){
                    schoolId = Integer.parseInt(request.getParameter("schoolid"));
                }
            } else {
                throw new Exception();
            }

            if(request.getParameter("subjectid") != null){
                subjectId = Integer.parseInt(request.getParameter("subjectid"));
            }
            if(request.getParameter("moduleid") != null){
                moduleId = Integer.parseInt(request.getParameter("moduleid"));
            }
            if(request.getParameter("taskname") != null){
                taskName = request.getParameter("taskname");
            }


            Syllabus syllabus = null;
            if(schoolId>0 && standardId>0 && subjectId>0) {
                Map<String, String> params = new HashMap<String, String>();
                params.put("syllabusDueDate", globalFunUtils.getDateTime());
                params.put("schoolId", String.valueOf(schoolId));
                params.put("standardId", String.valueOf(standardId));
                params.put("subjectId", String.valueOf(subjectId));
                params.put("taskName", taskName);
                params.put("moduleId", "0");
                params.put("pId", "0");
                params.put("studentId", "0");
                syllabus = syllabusDao.getSyllabusBySyllabusFilters(params);
            }
            model.addObject("schoolId", schoolId);
            model.addObject("standardId", standardId);
            model.addObject("subjectId", subjectId);
            model.addObject("moduleId", moduleId);

            model.addObject("syllabusForm", syllabus);
            if (syllabus == null)
                model.addObject("formAction", "/tasks/addtask/");
            else
                model.addObject("formAction", "/tasks/edittask/");
            model.setViewName("tasks/add_update");
            return model;
        } catch (Exception e) {
            return new ModelAndView("redirect:standard/manage?token=invalidselection&");
        }
    }

    @RequestMapping(value = "/addtask**", method = RequestMethod.POST)
    public ModelAndView addSyllabusPage(@ModelAttribute("taskForm") Syllabus taskForm) {
        ModelAndView model = new ModelAndView();
        User sessUser = globalFunUtils.getLoggedInUserDetail();
        if(sessUser.getRole().equals("ROLE_SCHOOL_ADMIN")){
            School school = schoolDao.getSchoolUsingPrincipalEmail(sessUser.getLogin());
            taskForm.setSchoolId(school.getSchoolId());
        }

        if(sessUser.getRole().equals("ROLE_TEACHER")){
            Teacher teacher = teacherDao.getTeacherUsingLoginId(sessUser.getUserId());
            taskForm.setSchoolId(teacher.getTeacherSchoolId());
        }

        String dateTime = globalFunUtils.getDateTime();
        taskForm.setModuleId(0);
        taskForm.setCreatedBy(sessUser.getLogin());
        taskForm.setCreatedDate(dateTime);
        taskForm.setLastUpdatedBy(sessUser.getLogin());
        taskForm.setLastUpdatedDate(dateTime);
        syllabusDao.create(taskForm);
        model.setViewName("redirect:content/?token=success&schoolid="+taskForm.getSchoolId()+"&standardid="+taskForm.getStandardId()+"&subjectid="+taskForm.getSubjectId()+"&taskname="+taskForm.getTaskName());
        return model;
    }

    @RequestMapping(value = "/edittask/**", method = RequestMethod.POST)
    public ModelAndView editSyllabusPage(@ModelAttribute("taskForm") Syllabus taskForm, HttpServletRequest request) {
        ModelAndView model = new ModelAndView();
        User sessUser = globalFunUtils.getLoggedInUserDetail();
        String dateTime = globalFunUtils.getDateTime();
        if(sessUser.getRole().equals("ROLE_SCHOOL_ADMIN")){
            School school = schoolDao.getSchoolUsingPrincipalEmail(sessUser.getLogin());
            taskForm.setSchoolId(school.getSchoolId());
        }
        if(sessUser.getRole().equals("ROLE_TEACHER")){
            Teacher teacher = teacherDao.getTeacherUsingLoginId(sessUser.getUserId());
            taskForm.setSchoolId(teacher.getTeacherSchoolId());
        }
        taskForm.setTaskId(Integer.parseInt(request.getParameter("taskId1")));
        taskForm.setLastUpdatedBy(sessUser.getLogin());
        taskForm.setLastUpdatedDate(dateTime);
        syllabusDao.update(taskForm);
        model.setViewName("redirect:/tasks/content/?token=success&schoolid="+taskForm.getSchoolId()+"&standardid="+taskForm.getStandardId()+"&subjectid="+taskForm.getSubjectId()+"&taskname="+taskForm.getTaskName());
        return model;
    }

    @RequestMapping(value = "/viewtask/**", method = RequestMethod.GET)
    public ModelAndView viewTaskPage(@ModelAttribute("taskForm") Syllabus taskForm, HttpServletRequest request) {
        ModelAndView model = new ModelAndView();
        User sessUser = globalFunUtils.getLoggedInUserDetail();
        String schoolId="0", standardId="0", subjectId="0";
        if(sessUser.getRole().equals("ROLE_SUP_ADMIN") || sessUser.getRole().equals("ROLE_SUB_ADMIN")) {
            if(request.getParameter("schoolid")==null || request.getParameter("standardid")==null || request.getParameter("subjectid")==null)
                model.setViewName("redirect:manage?token=invalidselection");
            schoolId=request.getParameter("schoolid");
            standardId=request.getParameter("standardid");
            subjectId=request.getParameter("subjectid");
        }else if(sessUser.getRole().equals("ROLE_STUDENT")) {
            if(request.getParameter("subjectid")==null)
                return new ModelAndView("redirect:dashboard?token=invalidselection");
            Student student = studentDao.getStudentUsingStudentLogin(sessUser.getLogin());
            schoolId=String.valueOf(student.getStuSchoolId());
            standardId=String.valueOf(student.getStuStandardId());
            subjectId=request.getParameter("subjectid");
            model.addObject("studentId", student.getStudentId());
        } else if(sessUser.getRole().equals("ROLE_PARENT")) {
            if(request.getParameter("subjectid")==null)
                return new ModelAndView("redirect:dashboard?token=invalidselection");
            Parents parents = parentsDao.getProfileUsingLoginId(sessUser.getLogin());
            int tempStudentId = parents.getStudentId();
            Student student = studentDao.getStudentUsingStudentId(tempStudentId);
            schoolId=String.valueOf(student.getStuSchoolId());
            standardId=String.valueOf(student.getStuStandardId());
            subjectId=request.getParameter("subjectid");
            model.addObject("studentId", student.getStudentId());
        } else {
            if(request.getParameter("standardid")==null || request.getParameter("subjectid")==null)
                model.setViewName("redirect:manage?token=invalidselection");
            standardId=request.getParameter("standardid");
            subjectId=request.getParameter("subjectid");

            if(sessUser.getRole().equals("ROLE_SCHOOL_ADMIN")) {
                School school = schoolDao.getSchoolUsingPrincipalEmail(sessUser.getLogin());
                schoolId=String.valueOf(school.getSchoolId());
            } else if(sessUser.getRole().equals("ROLE_HOD")) {
                Hod hod = hodDao.getHodByLoginId(sessUser.getLogin());
                schoolId=String.valueOf(hod.getHodSchoolId());
            }else if(sessUser.getRole().equals("ROLE_TEACHER")) {
                Teacher teacher = teacherDao.getTeacherUsingLoginId(sessUser.getUserId());
                schoolId=String.valueOf(teacher.getTeacherSchoolId());
            }
        }
        Map<String, String> params = new HashMap<String, String>();
        params.put("syllabusDueDate", globalFunUtils.getDateTime());
        params.put("schoolId", schoolId);
        params.put("standardId", standardId);
        params.put("subjectId", subjectId);
        params.put("pId", "0");
        params.put("studentId", "0");
        params.put("taskName",request.getParameter("taskname"));
        List<Syllabus> syllabus = syllabusDao.getSyllabusListBySyllabusFilters(params);
        Subject subject = subjectDao.getSubjectBySubjectId(Integer.parseInt(subjectId));
        model.addObject("subjectForm", subject);
        model.addObject("syllabusList", syllabus);

        model.setViewName("tasks/view");
        return model;
    }

    @RequestMapping(value = "/gettask/", method = RequestMethod.GET)
    public @ResponseBody
    String getLatestTasks(HttpServletRequest request) {
        String subjectId = "0";
        String schoolId = "0";
        String standardId = "0";
        String taskName = "";
        JSONObject obj = new JSONObject();

        if(request.getParameter("subjectId") != null){
            subjectId = request.getParameter("subjectId");
        }
        if(request.getParameter("schoolId") != null){
            schoolId = request.getParameter("schoolId");
        }
        if(request.getParameter("taskName") != null){
            taskName = request.getParameter("taskName");
        }
        if(request.getParameter("standardId") != null){
            standardId = request.getParameter("standardId");
        }
        Map<String, String> params = new HashMap<String, String>();
        params.put("syllabusDueDate", globalFunUtils.getDateTime());
        params.put("schoolId", schoolId);
        params.put("standardId", standardId);
        params.put("subjectId", subjectId);
        params.put("taskName", taskName);
        params.put("moduleId", "0");
        params.put("pId", "0");
        params.put("studentId", "0");
        Syllabus taskDetails = syllabusDao.getSyllabusBySyllabusFilters(params);
        if(taskDetails!=null){
            obj.put("result","true");
            obj.put("content",taskDetails.getContent());
            obj.put("dueDate", taskDetails.getTaskDueDate());
            obj.put("taskId", taskDetails.getTaskId());
        } else {
            obj.put("result", "false");
        }

        return obj.toString();
    }
}
