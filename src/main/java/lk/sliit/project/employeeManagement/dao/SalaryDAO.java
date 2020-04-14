package lk.sliit.project.employeeManagement.dao;

import lk.sliit.project.employeeManagement.entity.Employee;
import lk.sliit.project.employeeManagement.entity.Salary;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * @author: Rivindu-Wijayarathna
 * Date: 14-Apr-20
 */
public interface SalaryDAO  extends CrudRepository<Salary, String> {


    //Iterable<Salary> findAllBySalary();
    @Query(value = "SELECT name FROM emp1.employee WHERE idNo=?1", nativeQuery = true)
    String getEmployeeName(String idNo);
}
