package lk.sliit.project.employeeManagement.service.custom;

import lk.sliit.project.employeeManagement.dto.NoticeDTO;
import lk.sliit.project.employeeManagement.entity.Employee;
import lk.sliit.project.employeeManagement.service.SuperBO;
import lk.sliit.project.employeeManagement.dto.EmployeeDTO;
import java.util.List;

/**
 * @author: Rivindu-Wijayarathna
 * Date: 16-Mar-20
 */
//Dashboard Business Logic Interface
public interface DashboardBO extends SuperBO {
    //Get All Employee Count
    long getAllEmployeeCount();

    //Get Male Count
    long getMaleCount();

    //Get Female Count
    long getFemaleCount();

    //Upcoming birthdays 1 month
    List<EmployeeDTO> upcomingBirthDays();
    //Working Total Time From Attendance
    double getTotalTime();
//Total Projects Count
    double getTotalProjects();

    //Check Logging User name and password is match
    Employee findByIdNoAndPassword(String idNo, String password);

    //Find All Notice Between Today and Before 1 month
    List<NoticeDTO> findAllNoticeDesc();
}
