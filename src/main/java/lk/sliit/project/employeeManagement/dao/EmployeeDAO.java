package lk.sliit.project.employeeManagement.dao;

import lk.sliit.project.employeeManagement.entity.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.Date;

/**
 * @author: Minula
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


     //Check Is Admin when logging
     @Query( value = "SELECT admin FROM emp1.Employee WHERE idNo=?1",nativeQuery = true)
     boolean isAdmin(String idNo);
}
