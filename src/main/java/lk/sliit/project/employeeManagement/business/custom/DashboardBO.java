package lk.sliit.project.employeeManagement.business.custom;

import lk.sliit.project.employeeManagement.business.SuperBO;

import lk.sliit.project.employeeManagement.dto.EmployeeDTO;
import lk.sliit.project.employeeManagement.entity.Attendance;
import lk.sliit.project.employeeManagement.dto.AttendanceDTO;
import java.util.List;

/**
 * @author: Rivindu-Wijayarathna
 * Date: 16-Mar-20
 */
public interface DashboardBO extends SuperBO {
    long getAllEmployeeCount();

    long getMaleCount();

    long getFemaleCount();

    Attendance getEmployeeAttCount();

    void save(EmployeeDTO employee);

    EmployeeDTO updateUser(String user) ;

    void deleteUser(String id) ;

    List<EmployeeDTO> findAllEmployees() ;

    EmployeeDTO findUser(String userCode) ;
}
