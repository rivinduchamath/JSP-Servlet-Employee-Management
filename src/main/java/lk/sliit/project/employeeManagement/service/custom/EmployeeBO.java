package lk.sliit.project.employeeManagement.service.custom;

import lk.sliit.project.employeeManagement.service.SuperBO;
import lk.sliit.project.employeeManagement.dto.EmployeeDTO;
import java.util.List;

/**
 * @author: Minula
 * Date: 08-Mar-20
 */
//Employee Business Logic Interface
public interface EmployeeBO extends SuperBO {

    //Find User Is Exists
    boolean exists(String i);

    //Get All Employee Data By Id
    EmployeeDTO getEmployeeByIdNo(String idNo);

    //SAve Employee
    void save(EmployeeDTO employee);

    //Delete
    void deleteUser(String id) ;

    //Get All Employee
    List<EmployeeDTO> findAllEmployees() ;

}