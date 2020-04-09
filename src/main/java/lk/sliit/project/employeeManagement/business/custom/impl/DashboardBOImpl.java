package lk.sliit.project.employeeManagement.business.custom.impl;

import lk.sliit.project.employeeManagement.business.custom.DashboardBO;
import lk.sliit.project.employeeManagement.dao.AttendanceDAO;
import lk.sliit.project.employeeManagement.dao.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: Rivindu-Wijayarathna
 * Date: 16-Mar-20
 */
@Service
@Transactional
public class DashboardBOImpl implements DashboardBO {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Autowired
    private AttendanceDAO attendanceDAO;
    //Find Total Count Manual Query Method
    @Override
    public long  getAllEmployeeCount() { return employeeDAO.count (); }

    @Override
    public long getMaleCount() {
        return employeeDAO.countByGender("male");
    }

    @Override
    public long getFemaleCount() {
        return employeeDAO.countByGender("female");
    }

    @Override
    public long getEmployeeAttCount() {
        return attendanceDAO.count();
    }
}
