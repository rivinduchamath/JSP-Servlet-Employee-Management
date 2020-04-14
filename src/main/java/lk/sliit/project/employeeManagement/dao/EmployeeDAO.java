package lk.sliit.project.employeeManagement.dao;

import lk.sliit.project.employeeManagement.entity.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * @author: Rivindu-Wijayarathna
 * Date: 08-Mar-20
 */
public interface EmployeeDAO extends CrudRepository<Employee, String> {
     Long countByGender(String gender);
     Employee findByIdNoAndPassword(String idNo, String password);
     Employee getEmployeeByIdNo(String idNo);
     @Query(value = "SELECT name FROM emp1.employee WHERE idNo=?1", nativeQuery = true)
     String findName(String idNo);
     @Query(value = "SELECT occupation FROM emp1.employee WHERE idNo=?1", nativeQuery = true)
     String findPos(String idNo);
     @Query(value = "SELECT Pic FROM emp1.employee WHERE idNo=?1", nativeQuery = true)
    String findPic(String idNo);
}
