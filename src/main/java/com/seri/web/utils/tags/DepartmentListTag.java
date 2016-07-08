package com.seri.web.utils.tags;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.seri.service.notification.RoleType;
import com.seri.web.controller.SchoolController;
import com.seri.web.dao.DepartmentDao;
import com.seri.web.dao.daoImpl.DepartmentDaoImpl;
import com.seri.web.model.Department;
import com.seri.web.utils.LoggedUserUtil;

/**
 * Created by puneet on 23/05/16.
 */
public class DepartmentListTag extends SimpleTagSupport {

    private SchoolController schoolController = new SchoolController();
    private String ctrlName;
    private String ctrlId;
    private String ctrlClass;
    private String selectedDepartment;
    private DepartmentDao departmentDao = new DepartmentDaoImpl();

    public void setCtrlName(String ctrlName) {
        this.ctrlName = ctrlName;
    }

    public void setCtrlId(String ctrlId) {
        this.ctrlId = ctrlId;
    }

    public void setCtrlClass(String ctrlClass) {
        this.ctrlClass = ctrlClass;
    }

    public void setSelectedDepartment(String selectedDepartment) {
        this.selectedDepartment = selectedDepartment;
    }

    public void doTag() throws IOException {
        if (ctrlClass == null || ctrlClass == "")
            ctrlClass = "departmentList";

        if (ctrlId == null || ctrlId == "")
            ctrlId = "departmentList";

        if (ctrlName == null || ctrlName == "")
            ctrlName = "departmentList";

        if (selectedDepartment == null || selectedDepartment == "")
            selectedDepartment = "0";

        String ctrl = schoolController.getDepartmentListing(ctrlName,ctrlId,ctrlClass,selectedDepartment);

        JspWriter out = getJspContext().getOut();

        if(LoggedUserUtil.hasRole(RoleType.ROLE_HOD)) {
            Department department = departmentDao.getDepartmentUsingId(Integer.parseInt(selectedDepartment));
            //ctrl = "<span>"+department.getDepartmentName()+"</span><input type='hidden' id='departmentId' value='"+department.getDepartmentId()+"' />";
        }
        out.println(ctrl);

    }
}
