package lk.sliit.project.employeeManagement.business.custom;

import lk.sliit.project.employeeManagement.business.SuperBO;
import lk.sliit.project.employeeManagement.dto.SalaryDTO;
import java.util.List;

/**
 * @author: Rivindu-Wijayarathna
 * Date: 13-Apr-20
 */
public interface SalaryBO extends SuperBO {

    List <SalaryDTO> findAllSalary();

    void updateSalary(SalaryDTO employee);

    List <SalaryDTO> getSalaryData(String idNo);
}
