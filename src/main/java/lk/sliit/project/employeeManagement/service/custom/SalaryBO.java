package lk.sliit.project.employeeManagement.service.custom;

import lk.sliit.project.employeeManagement.service.SuperBO;
import lk.sliit.project.employeeManagement.dto.SalaryDTO;
import java.util.List;

/**
 * @author: Chanuka
 * Date: 13-Apr-20
 */
public interface SalaryBO extends SuperBO {

    List <SalaryDTO> findAllSalary();

    void updateSalary(SalaryDTO employee);

    List <SalaryDTO> getSalaryData(String idNo);


    void deleteSalary(String idNo);

}
