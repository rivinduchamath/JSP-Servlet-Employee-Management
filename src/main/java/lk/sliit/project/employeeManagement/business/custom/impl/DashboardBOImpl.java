package lk.sliit.project.employeeManagement.business.custom.impl;

import lk.sliit.project.employeeManagement.business.custom.DashboardBO;
import lk.sliit.project.employeeManagement.dao.AttendanceDAO;
import lk.sliit.project.employeeManagement.dao.EmployeeDAO;

import lk.sliit.project.employeeManagement.dto.EmployeeDTO;
import lk.sliit.project.employeeManagement.entity.Attendance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public Attendance getEmployeeAttCount() {
        return attendanceDAO.findTopByOrderByAttendanceIdDesc();
    }

    @Override
    public void save(EmployeeDTO employee) {

    }

    @Override
    public EmployeeDTO updateUser(String user) {
        return null;
    }

    @Override
    public void deleteUser(String id) {

    }

    @Override
    public List<EmployeeDTO> findAllEmployees() {
        return null;
    }

    @Override
    public EmployeeDTO findUser(String userCode) {
        return null;
    }
}
