package lk.sliit.project.employeeManagement.dao;

import lk.sliit.project.employeeManagement.entity.Attendance;
import org.springframework.data.repository.CrudRepository;

/**
 * @author: Rivindu-Wijayarathna
 * Date: 22-Mar-20
 */
public interface AttendanceDAO extends CrudRepository<Attendance, Integer> {
}
