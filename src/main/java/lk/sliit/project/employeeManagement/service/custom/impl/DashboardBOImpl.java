package lk.sliit.project.employeeManagement.service.custom.impl;

import lk.sliit.project.employeeManagement.dao.ProjectDAO;
import lk.sliit.project.employeeManagement.entity.Employee;
import lk.sliit.project.employeeManagement.service.custom.DashboardBO;
import lk.sliit.project.employeeManagement.dao.AttendanceDAO;
import lk.sliit.project.employeeManagement.dao.EmployeeDAO;
import lk.sliit.project.employeeManagement.dto.AttendanceDTO;
import lk.sliit.project.employeeManagement.dto.EmployeeDTO;
import lk.sliit.project.employeeManagement.entity.Attendance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
    private ProjectDAO projectDAO;

    @Autowired
    private AttendanceDAO attendanceDAO;
    //Find Total Count Manual Query Method
    @Override
    public long  getAllEmployeeCount() { return employeeDAO.count (); }

    //Find Male Count To Dashboard
    @Override
    public long getMaleCount() {
        return employeeDAO.countByGender("male");
    }

    //Find Female Count To Dashboard
    @Override
    public long getFemaleCount() {
        return employeeDAO.countByGender("female");
    }

    //
    @Override
    public AttendanceDTO getEmployeeAttCount() {
        Attendance employee = attendanceDAO.findTopByOrderByAttendanceIdDesc ();
        return new AttendanceDTO (
                employee.getAttendanceId ()
        );
    }
    @Override
    public List <EmployeeDTO> upcomingBirthDays() {
        DateFormat dateFormat = new SimpleDateFormat ("yyyy/MM/dd");
        Date todaydate = new Date();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, 1);
        java.util.Date dt = cal.getTime();
        Iterable <Employee> employees = employeeDAO.findEmployeesByDateOfBirthBetween (todaydate ,dt);
        List <EmployeeDTO> dtos = new ArrayList<> ( );
        for (Employee employeee : employees) {
            dtos.add ( new EmployeeDTO (
                    employeee.getIdNo (),
                    employeee.getName (),
                    employeee.getPic (),
                    employeee.getOccupation (),
                    employeee.getDateOfBirth ()
            ) );
        }
        return dtos;
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

    @Override
    public double getTotalTime() {
        Iterable <Attendance> allItems = attendanceDAO.findAll ();
    double tot =0;
    double t =0;
    double count = 0;
        for (Attendance attendance : allItems) {
            tot= attendance.getOvertimeHours ();
            t++;
            count += tot;
        }
        count += (t *8);
        return count;
    }

    @Override
    public double getTotalProjects() {
        return projectDAO.count ();
    }
}
