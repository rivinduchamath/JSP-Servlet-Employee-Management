package lk.sliit.project.employeeManagement.service.custom;

import lk.sliit.project.employeeManagement.service.SuperBO;
import lk.sliit.project.employeeManagement.dto.AttendanceDTO;
import java.util.List;

/**
 * @author: Rivindu-Wijayarathna
 * Date: 09-Apr-20
 */
//Attendance Business Logic Interface
public interface AttendanceBO extends SuperBO {
    //Get Today attendance
    List<AttendanceDTO> findTodayAttendance();

    //Get top attendance id
    AttendanceDTO findTopByOrderByAttendanceIdDesc();

    //Save Or Update Attendance
    void saveOrUpdate(AttendanceDTO attendance);

    //Delete
    void deleteAttendance(String id) ;

    //Get All Attendance
    List<AttendanceDTO> findAllAtendance();
}
