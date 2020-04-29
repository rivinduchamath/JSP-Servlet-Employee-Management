package lk.sliit.project.employeeManagement.dao;

import lk.sliit.project.employeeManagement.entity.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.Date;

/**
 * @author: Rivindu-Wijayarathna
 * Date: 08-Mar-20
 */
//Interface EmployeeDAO Extend From CrudRepository InterFace
public interface EmployeeDAO extends CrudRepository<Employee, String> {

     //Get Total employee Count
     Long countByGender(String gender);

     //Get Logger User Name And Password is Ok
     Employee findByIdNoAndPassword(String idNo, String password);

     //Get All Emplyee By Id No
     Employee getEmployeeByIdNo(String idNo);

     //Get Name For Attendance Load today Table
     @Query(value = "SELECT name FROM emp1.employee WHERE idNo=?1", nativeQuery = true)
     String findName(String idNo);

     //Get findPos For Attendance Load today Table
     @Query(value = "SELECT occupation FROM emp1.employee WHERE idNo=?1", nativeQuery = true)
     String findPos(String idNo);

     //findPic For Attendance Load today Table
     @Query(value = "SELECT Pic FROM emp1.employee WHERE idNo=?1", nativeQuery = true)
     String findPic(String idNo);

     Iterable<Employee> findEmployeesByDateOfBirthBetween(Date date,Date date1);

}
