package lk.sliit.project.employeeManagement.service.custom;

import lk.sliit.project.employeeManagement.service.SuperBO;
import lk.sliit.project.employeeManagement.dto.EmployeeDTO;
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

    AttendanceDTO getEmployeeAttCount();

    void save(EmployeeDTO employee);

    EmployeeDTO updateUser(String user) ;

    void deleteUser(String id) ;

    List<EmployeeDTO> findAllEmployees() ;
    List<EmployeeDTO> upcomingBirthDays();
    EmployeeDTO findUser(String userCode) ;
}
