package com.seri.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.seri.service.notification.RoleType;
import com.seri.web.dao.DepartmentDao;
import com.seri.web.dao.HodDao;
import com.seri.web.dao.SchoolDao;
import com.seri.web.dao.StudentDao;
import com.seri.web.dao.TeacherDao;
import com.seri.web.dao.UserDao;
import com.seri.web.dao.daoImpl.DepartmentDaoImpl;
import com.seri.web.dao.daoImpl.HodDaoImpl;
import com.seri.web.dao.daoImpl.SchoolDaoImpl;
import com.seri.web.dao.daoImpl.StudentDaoImpl;
import com.seri.web.dao.daoImpl.TeacherDaoImpl;
import com.seri.web.dao.daoImpl.UserDaoImpl;
import com.seri.web.model.Department;
import com.seri.web.model.Hod;
import com.seri.web.model.School;
import com.seri.web.model.Teacher;
import com.seri.web.model.User;
import com.seri.web.utils.CalendarUtil;
import com.seri.web.utils.LoggedUserUtil;

/**
 * Created by puneet on 24/05/16.
 */
@Controller
@RequestMapping(value = "hod")
public class HodController {
    private SchoolDao schoolDao = new SchoolDaoImpl();
    private UserDao userDao = new UserDaoImpl();
    private StudentDao studentDao = new StudentDaoImpl();
    private TeacherDao teacherDao = new TeacherDaoImpl();
    private HodDao hodDao = new HodDaoImpl();
    private DepartmentDao departmentDao = new DepartmentDaoImpl();

    @RequestMapping(value = "/manage**", method = RequestMethod.GET)
    public ModelAndView manageHodPage(HttpServletRequest request) {
        ModelAndView model = new ModelAndView();
        model.setViewName("hod/manage_hod");
        return model;
    }

    @RequestMapping(value = "/hodlisting/", method = RequestMethod.GET)
    public @ResponseBody
    String getHodListing(HttpServletRequest request) {
        int rpp = 10;
        int p=1;
        int offset = 0;
        String retHtml = "";

        List<Hod> hodList = null;
        List<Hod> countHodList = null;
        Map<String, Integer> params = new HashMap<String, Integer>();
        Map<String, Integer> params2 = new HashMap<String, Integer>();

        if(request.getParameter("rpp") != null)
            rpp = Integer.valueOf(request.getParameter("rpp"));

        if(request.getParameter("p")!=null) {
            p = Integer.valueOf(request.getParameter("p"));
            offset = rpp*(p-1);
        }

        params.put("offset", offset);
        params.put("rpp", rpp);

        int schoolId = 0;

        if(LoggedUserUtil.hasRole(RoleType.ROLE_SUB_ADMIN)) {
            if(request.getParameter("schoolid") != null) {
                params.put("schoolid", Integer.valueOf(request.getParameter("schoolid")));
                schoolId = Integer.valueOf(request.getParameter("schoolid"));
            }

        } else if(LoggedUserUtil.hasRole(RoleType.ROLE_SCHOOL_ADMIN)) {
            School school = schoolDao.getSchoolUsingPrincipal(LoggedUserUtil.getUserId());
            params.put("schoolid", school.getSchoolId());
            schoolId = school.getSchoolId();
        }

        hodList = hodDao.getAllHodByFilters(params, false);
        countHodList = hodDao.getAllHodByFilters(params, true);
        List<Department> departmentList = departmentDao.getDepartmentList();

        if(hodList != null && hodList.size()>0){
            retHtml = "<table class=\"table table-bordered responsive\">\n" +
                    "                <thead>\n" +
                    "                <tr>\n" +
                    "                    <th></th>\n" +
                    "                    <th>Hod Name</th>\n" +
                    "                    <th>Email (LoginId)</th>\n" +
                    "                    <th>Department Name</th>\n" +
                    "                    <th>Address</th>\n" +
                    "                    <th>Other Information</th>\n" +
                    "                    <th>&nbsp;</th>\n" +
                    "                </tr>\n" +
                    "                </thead>\n" +
                    "                <tbody>\n";

            for (Hod hod:hodList) {
                params.put("departmentId", hod.getHodDepartmentId());
                List<Teacher> countHodListTemp = teacherDao.getTeacherListUsingSchoolId(params, true);
                String depName = "";
                for (Department tempDepartment:departmentList) {
                    if(tempDepartment.getDepartmentId()==hod.getHodDepartmentId())
                        depName=tempDepartment.getDepartmentName();
                }
                retHtml+="<tr><td></td>";
                retHtml+="<td>"+hod.getfName()+" "+hod.getlName() + "</td>";
                retHtml+="<td>"+hod.getEmail()+"</td>";
                retHtml+="<td>"+depName+"</td>";
                retHtml+="<td>"+hod.getHodAddress()+"</td>";
                retHtml+="<td><a href='/teacher/manage/?schoolid="+schoolId+"&departmentid="+hod.getHodDepartmentId()+"'>Teacher Count: "+countHodListTemp.size()+"</a></td>";
                retHtml+="<td>"+"<a href=\"/hod/update?id="+hod.getHodId()+"&p="+p+"&rpp="+rpp+"\" class=\"editSchool\"><span class=\"icon-edit\"></span></a></td>";
                retHtml+="</tr>";
            }

            retHtml+="</tbody>\n" +
                    "</table>";

            if(countHodList.size() > hodList.size()){
                retHtml+= "<ul class=\"pager\" data-p='"+p+"'>\n";
                if(p==1)
                    retHtml+="<li class='disabled'><a href=\"#\">Previous</a></li>\n";
                else
                    retHtml+="<li class=''><a href=\"#\" data-p='"+(p-1)+"'>Previous</a></li>\n";

                if(p < countHodList.size()/rpp)
                    retHtml+="<li><a href=\"javascript:void(0)\" data-p='"+(p+1)+"'>Next</a></li></ul>";
                else
                    retHtml+="<li class='disabled'><a href=\"javascript:void(0)\" data-p='"+(p+1)+"'>Next</a></li></ul>";


            }
        }
        return retHtml;
    }

    @RequestMapping(value = "/update**", method = RequestMethod.GET)
    public ModelAndView updateHod(HttpServletRequest request) {
        ModelAndView model = new ModelAndView();

        if(request.getParameter("id") == null)
            return new ModelAndView("redirect:manage_hod");

        int id = Integer.parseInt(request.getParameter("id"));

        Hod hodProfile = hodDao.getHodByHodId(id);
        if(hodProfile==null)
            return new ModelAndView("redirect:manage_hod");

        if(LoggedUserUtil.hasRole(RoleType.ROLE_SCHOOL_ADMIN)) {
            School tempSchool = schoolDao.getSchoolUsingPrincipal(LoggedUserUtil.getUserId());
            if(tempSchool.getSchoolId()!=hodProfile.getHodSchoolId()) {
                return new ModelAndView("redirect:manage_hod");
            }
        } else if(LoggedUserUtil.hasRole(RoleType.ROLE_HOD)) {
            Hod tempHod = hodDao.getHodByUserId(LoggedUserUtil.getUserId());
            if(tempHod.getHodSchoolId()!=hodProfile.getHodSchoolId() || tempHod.getHodDepartmentId()!=hodProfile.getHodDepartmentId()) {
                return new ModelAndView("redirect:manage_hod");
            }
        }

        User userForm = userDao.getUserUsingEmail(hodProfile.getEmail());

        model.addObject("userForm", userForm);
        model.addObject("hodForm", hodProfile);
        model.addObject("formAction", "hodUpdate");

        model.setViewName("hod/hod_update");
        return model;
    }

    public Boolean addUpdate(Hod hod) {
        Boolean flag = false;
        hod.setLastUpdatedBy(LoggedUserUtil.getUserId());
        hod.setLastUpdatedDate(CalendarUtil.getDate());

        Hod tempDetails = hodDao.getHodByHodId(hod.getHodId());
        if(tempDetails != null)
        {
            if(LoggedUserUtil.hasRole(RoleType.ROLE_HOD)) {
                hod.setHodSchoolId(tempDetails.getHodSchoolId());
                hod.setHodDepartmentId(tempDetails.getHodDepartmentId());
            }
            hod.setHodUserId(tempDetails.getHodUserId());
            hod.setEmail(tempDetails.getEmail());
            hod.setCreatedBy(tempDetails.getCreatedBy());
            hod.setCreatedDate(tempDetails.getCreatedDate());
            hod.setGender(tempDetails.getGender());
            hodDao.update(hod);
        } else {
            hod.setCreatedDate(CalendarUtil.getDate());
            hod.setCreatedBy(LoggedUserUtil.getUserId());
            hodDao.create(hod);
        }
        return flag;
    }
}
