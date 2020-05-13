package lk.sliit.project.employeeManagement.service.custom;

import lk.sliit.project.employeeManagement.service.SuperBO;
import lk.sliit.project.employeeManagement.dto.SalaryDTO;
import java.util.List;

/**
 * @author: Chanuka
 * Date: 13-Apr-20
 */
//Salary Business Logic Interface
public interface SalaryBO extends SuperBO {

    //Get All Salary
    List <SalaryDTO> findAllSalary();

    //Update OR SAVE Employee Salary
    void saveOrUpdateSalary(SalaryDTO employee);

    //Find Salary By ID(Clicked Check Box) This String Has List Of Salary IDs Ex: "S001 S002"
    List <SalaryDTO> getSalaryData(String idNo);

     //Delete Salary
    void deleteSalary(String idNo);

}
