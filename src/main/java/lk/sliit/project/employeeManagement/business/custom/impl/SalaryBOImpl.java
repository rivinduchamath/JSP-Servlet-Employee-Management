package lk.sliit.project.employeeManagement.business.custom.impl;

import lk.sliit.project.employeeManagement.business.custom.SalaryBO;
import lk.sliit.project.employeeManagement.dao.EmployeeDAO;
import lk.sliit.project.employeeManagement.dao.SalaryDAO;
import lk.sliit.project.employeeManagement.dto.EmployeeDTO;
import lk.sliit.project.employeeManagement.entity.Attendance;
import lk.sliit.project.employeeManagement.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: Rivindu-Wijayarathna
 * Date: 13-Apr-20
 */
@Service
@Transactional
public class SalaryBOImpl implements SalaryBO {

    @Autowired
    private SalaryDAO salaryDAO;
    @Override
    public void updateSalary(EmployeeDTO employee) {

        salaryDAO.save(new Employee (employee.getIdNo (),
                employee.getIdNo (),
                employee.getSalary (),
                employee.getTotalOtHours (),
                employee.getPaymentDueTo ()

        ));
    }


}
