package lk.sliit.project.employeeManagement.dao;

import lk.sliit.project.employeeManagement.entity.Attendance;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.Date;

/**
 * @author: Rivindu-Wijayarathna
 * Date: 22-Mar-20
 */
//Interface AttendanceDAO Extend From CrudRepository InterFace
public interface AttendanceDAO extends CrudRepository<Attendance, String> {

    //Get Highest Attendance Id No
    Attendance findTopByOrderByAttendanceIdDesc();

    //Get Today attendance
    Iterable<Attendance> findAttendanceByDateEquals(Date date);
    @Query(value = "SELECT overtimeHours FROM attendance WHERE employeeId=?1", nativeQuery = true)
    double getEmp(String idNo);
}
