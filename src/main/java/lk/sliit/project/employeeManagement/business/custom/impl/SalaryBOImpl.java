package lk.sliit.project.employeeManagement.business.custom.impl;

import lk.sliit.project.employeeManagement.business.custom.SalaryBO;
import lk.sliit.project.employeeManagement.dao.EmployeeDAO;
import lk.sliit.project.employeeManagement.dao.SalaryDAO;
import lk.sliit.project.employeeManagement.dto.EmployeeDTO;
import lk.sliit.project.employeeManagement.dto.SalaryDTO;
import lk.sliit.project.employeeManagement.entity.Attendance;
import lk.sliit.project.employeeManagement.entity.Employee;
import lk.sliit.project.employeeManagement.entity.Salary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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
    public void updateSalary(SalaryDTO employee) {

        salaryDAO.save(new Salary (
                employee.getSalaryId (),
                employee.getSalary (),
                employee.getTotalOtHours (),
                employee.getFullPayment (),
                employee.getEmployee ()

        ));
    }

    @Override
    public List<SalaryDTO> findAllSalaries() {
        Iterable <Salary> allItems = salaryDAO.findAll();
        List <SalaryDTO> dtos = new ArrayList<> ();
        for (Salary salary : allItems) {
            dtos.add(new SalaryDTO (
                    salary.getSalaryId (),
                    salary.getSalary (),
                    salary.getTotalOtHours (),
                    salary.getFullPayment (),
                    salary.getEmployeeID ()
            ));
        }
        return dtos;
    }

    @Override
    public Salary getSalaryId() {
        return salaryDAO.findTopByOrderBySalaryIdDesc();
    }



}
