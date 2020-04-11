package lk.sliit.project.employeeManagement.dao;

import lk.sliit.project.employeeManagement.entity.Attendance;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;

/**
 * @author: Rivindu-Wijayarathna
 * Date: 22-Mar-20
 */
public interface AttendanceDAO extends CrudRepository<Attendance, String> {
    Attendance findTopByOrderByAttendanceIdDesc();

    Iterable<Attendance> findAttendanceByDateEquals(Date date);
}
