package lk.sliit.project.employeeManagement.dao;

import lk.sliit.project.employeeManagement.entity.Salary;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * @author: Rivindu-Wijayarathna
 * Date: 14-Apr-20
 */
//Interface SalaryDAO Extend From CrudRepository InterFace
public interface SalaryDAO  extends CrudRepository<Salary, String> {

    // Select Name From Id
    @Query(value = "SELECT name FROM emp1.employee WHERE idNo=?1", nativeQuery = true)
    String getEmployeeName(String idNo);

}
