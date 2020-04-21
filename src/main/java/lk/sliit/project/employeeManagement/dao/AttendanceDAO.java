package lk.sliit.project.employeeManagement.dao;

import lk.sliit.project.employeeManagement.entity.Attendance;
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

}
