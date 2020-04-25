package lk.sliit.project.employeeManagement.business.custom.impl;

import lk.sliit.project.employeeManagement.business.custom.SalaryBO;
import lk.sliit.project.employeeManagement.dao.AttendanceDAO;
import lk.sliit.project.employeeManagement.dao.EmployeeDAO;
import lk.sliit.project.employeeManagement.dao.QueryDAO;
import lk.sliit.project.employeeManagement.dao.SalaryDAO;
import lk.sliit.project.employeeManagement.dto.CustomDTO;
import lk.sliit.project.employeeManagement.dto.SalaryDTO;
import lk.sliit.project.employeeManagement.entity.CustomEntity;
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
    @Autowired
    private QueryDAO queryDAO;
    @Autowired
    AttendanceDAO attendanceDAO;
    @Override

    public void updateSalary(SalaryDTO employee) {

        salaryDAO.save(new Salary (
              employee.getSalaryId (),
                employee.getBasicSalary (),
                employee.getOtHours (),
                employee.getOtRate (),
                employee.getBonus (),
                employee.getIncomeTax (),
                employee.getEmployeeID ())
            );
    }

    @Override
    public List <SalaryDTO> getSalaryData(String source) {
       List<String> list=new ArrayList<String>();
        String[] sourceAry = source.split(" ");

        for(String value : sourceAry) {
            list.add (value );
        }
        Iterable <Salary> all = salaryDAO.findAll (list);
        List <SalaryDTO> dtos = new ArrayList<> ();
        for (Salary salary : all) {
            dtos.add(new SalaryDTO (
                    salary.getSalaryId (),
                    salary.getBasicSalary (),
                    salary.getOtHours (),
                    salary.getOtRate (),
                    salary.getBonus (),
                    salary.getIncomeTax (),
                    salary.getEmployeeID ()));
        }
        return dtos;
    }

    @Override
    public void deleteSalary(String idNo) {
        salaryDAO.delete (idNo);
    }


    @Override
    public List<SalaryDTO> findAllSalary() {
        Iterable <Salary> all = salaryDAO.findAll ( );
        List <SalaryDTO> dtos = new ArrayList<> ();
        for (Salary salary : all) {
            dtos.add(new SalaryDTO (
                    salary.getSalaryId (),
                    salary.getBasicSalary (),
                    salary.getOtHours (),
                    salary.getOtRate (),
                    salary.getBonus (),
                    salary.getIncomeTax (),
                    salary.getEmployeeID ()));
        }
        return dtos;
    }


}
