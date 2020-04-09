package lk.sliit.project.employeeManagement.dao;

import lk.sliit.project.employeeManagement.entity.Employee;
import org.springframework.data.repository.CrudRepository;
/**
 * @author: Rivindu-Wijayarathna
 * Date: 08-Mar-20
 */
public interface EmployeeDAO extends CrudRepository<Employee,String> {
     Long countByGender(String gender);
     Employee findByIdNoAndPassword(String idNo, String password);
     Employee getEmployeeByIdNo(String idNo);

}
