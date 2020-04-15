package lk.sliit.project.employeeManagement.business.custom;

import lk.sliit.project.employeeManagement.dto.EmployeeDTO;
import lk.sliit.project.employeeManagement.dto.SalaryDTO;
import lk.sliit.project.employeeManagement.entity.Salary;

import java.util.List;

/**
 * @author: Rivindu-Wijayarathna
 * Date: 13-Apr-20
 */
public interface SalaryBO {

    List <SalaryDTO> findAllSalary();

    void updateSalary(SalaryDTO employee);

}
