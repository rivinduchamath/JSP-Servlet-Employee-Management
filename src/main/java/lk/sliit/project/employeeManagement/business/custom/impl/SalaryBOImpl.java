package lk.sliit.project.employeeManagement.business.custom.impl;

import lk.sliit.project.employeeManagement.business.custom.SalaryBO;
import lk.sliit.project.employeeManagement.dao.EmployeeDAO;
import lk.sliit.project.employeeManagement.dao.SalaryDAO;
import lk.sliit.project.employeeManagement.dto.SalaryDTO;
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
    @Autowired
    private EmployeeDAO employeeDAO;


    @Override

    public void updateSalary(SalaryDTO employee) {

        salaryDAO.save(new Salary (
              employee.getSalaryId (),
                employee.getSalary (),
                employee.getTotalOtHours (),
                employee.getFullPayment (),
                employeeDAO.findOne (employee.getEmployee ())));
    }

    @Override
    public List <SalaryDTO> getSalaryData(String source) {
        System.out.println ( "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"+source);

        List<String> list=new ArrayList<String>();
        String[] sourceAry = source.split(" ");

        for(String value : sourceAry) {
            list.add (value );
        }
//        for (String s: list) {
//            System.out.println ("sssssssssssssssssaaaaaaaaaaaaaaaaaa"+s);
//    }
        Iterable <Salary> all = salaryDAO.findAll (list);
        System.out.println ("sssssssssssssssssssssssssssss"+all );
        List <SalaryDTO> dtos = new ArrayList<> ();
        for (Salary salary : all) {
            dtos.add(new SalaryDTO (
                    salary.getSalaryId (),
                    salary.getFullPayment (),
                    salary.getSalary (),
                    salary.getTotalOtHours (),
                    salary.getEmployeeID ().getIdNo (),
                    salaryDAO.getEmployeeName( salary.getEmployeeID ().getIdNo ())));


            System.out.println ( "aaaaaaaaaaaaaaaaaaaaaa"+salary.getSalaryId () );
        }
        return dtos;
    }

    @Override
    public List<SalaryDTO> findAllSalary() {
        Iterable <Salary> all = salaryDAO.findAll ( );
        List <SalaryDTO> dtos = new ArrayList<> ();
        for (Salary salary : all) {
            dtos.add(new SalaryDTO (
                    salary.getSalaryId (),
                    salary.getFullPayment (),
                    salary.getSalary (),
                    salary.getTotalOtHours (),
                    salary.getEmployeeID ().getIdNo (),
                    salaryDAO.getEmployeeName( salary.getEmployeeID ().getIdNo ())
            ));
        }
        return dtos;
    }


}
