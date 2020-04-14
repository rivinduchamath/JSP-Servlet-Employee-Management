package lk.sliit.project.employeeManagement.dao;

import lk.sliit.project.employeeManagement.entity.Salary;
import org.springframework.data.repository.CrudRepository;

/**
 * @author: Rivindu-Wijayarathna
 * Date: 14-Apr-20
 */
public interface SalaryDAO  extends CrudRepository<Salary, String> {
 Salary findTopByOrderBySalaryIdDesc();
}
