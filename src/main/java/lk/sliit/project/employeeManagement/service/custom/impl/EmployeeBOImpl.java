package lk.sliit.project.employeeManagement.service.custom.impl;

import lk.sliit.project.employeeManagement.service.custom.EmployeeBO;
import lk.sliit.project.employeeManagement.dao.EmployeeDAO;
import lk.sliit.project.employeeManagement.dto.EmployeeDTO;
import lk.sliit.project.employeeManagement.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Minula
 * Date: 08-Mar-20
 */
@Service
@Transactional//Employee BusinessLogic / Service Implementation Class
public class EmployeeBOImpl implements EmployeeBO {

    //Automate Object Creation
    @Autowired
    private EmployeeDAO employeeDAO;

    //Save Method
    @Override
    public void save(EmployeeDTO employee) {
        employeeDAO.save(new Employee (employee.getIdNo (),
                employee.getName (),
                employee.getMobileNumber (),
                employee.getEmail (),
                employee.getAddress (),
                employee.getOccupation (),
                employee.getPassword (),
                employee.getDateOfBirth (),
                employee.getGender (),
                employee.getDate (),
                employee.getPic (),
                employee.isAdmin ()

        ));
    }//End Save


    //Delete Method
    @Override
    public void deleteUser(String userCode) { employeeDAO.delete (userCode); }

    //Search All Employees Method
    @Override
    @Transactional(readOnly = true)
    public List<EmployeeDTO> findAllEmployees() {
        Iterable <Employee> allItems = employeeDAO.findAll();
        List <EmployeeDTO> dtos = new ArrayList <> ();
        for (Employee employee : allItems) {
            dtos.add(new EmployeeDTO (
                    employee.getIdNo (),
                    employee.getName (),
                    employee.getMobileNumber (),
                    employee.getEmail (),
                    employee.getAddress (),
                    employee.getOccupation (),
                    employee.getPassword (),
                    employee.getDateOfBirth (),
                    employee.getGender (),
                    employee.getDate (),
                    employee.getPic (),
                    employee.isAdmin ()
            ));
        }
        return dtos;
    }//End Find All

    @Override//Check Employee Is Exists
    public boolean exists(String i) {
        if ( employeeDAO.exists (  ( i ) )) {
            return true;
        }
        return false;
    }


    @Override//Find Employee by id
    @Transactional(readOnly = true)
    public EmployeeDTO getEmployeeByIdNo(String idNo) {
        Employee employee = employeeDAO.findOne (idNo);
        return new EmployeeDTO (employee.getIdNo (),
                employee.getName (),
                employee.getMobileNumber (),
                employee.getEmail (),
                employee.getAddress (),
                employee.getOccupation (),
                employee.getPassword (),
                employee.getDateOfBirth (),
                employee.getGender (),
                employee.getDate (),
                employee.getPic (),
                employee.isAdmin ()
                );

    }//End Find by id

}//End Class