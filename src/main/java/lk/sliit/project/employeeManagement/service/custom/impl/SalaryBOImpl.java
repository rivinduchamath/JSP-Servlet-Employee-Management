package lk.sliit.project.employeeManagement.service.custom.impl;

import lk.sliit.project.employeeManagement.service.custom.SalaryBO;
import lk.sliit.project.employeeManagement.dao.AttendanceDAO;
import lk.sliit.project.employeeManagement.dao.SalaryDAO;
import lk.sliit.project.employeeManagement.dto.SalaryDTO;
import lk.sliit.project.employeeManagement.entity.Salary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author: Chanuka
 * Date: 13-Apr-20
 */
@Service
@Transactional //Salary BusinessLogic / Service Implementation Class
public class SalaryBOImpl implements SalaryBO {
    //Automate Object Creation
    @Autowired
    private SalaryDAO salaryDAO;
    @Autowired
    AttendanceDAO attendanceDAO;

    @Override //SAVE OR Update Salary
    public void saveOrUpdateSalary(SalaryDTO salaryDTO) {
        salaryDAO.save(new Salary (
                salaryDTO.getSalaryId (),
                salaryDTO.getBasicSalary (),
                salaryDTO.getOtHours (),
                salaryDTO.getOtRate (),
                salaryDTO.getBonus (),
                salaryDTO.getIncomeTax (),
                salaryDTO.getEmployeeID ())
            );
    }//End Update OR Save

    @Override//Get Salary Data When Clicked Check Box
    @Transactional(readOnly = true)
    public List <SalaryDTO> getSalaryData(String source) { //Get All Salaries Ex: S001 S002
       List<String> list=new ArrayList<String>();
        String[] sourceAry = source.split(" "); //Split that String source

        for(String value : sourceAry) { //Add String Array to List
            list.add (value );
        }
        Iterable <Salary> all = salaryDAO.findAll (list); //Find All Salary In the List
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
        return dtos;//Return Clicked Salaries Only
    }//End Get Salary Data When Clicked Check Box

    @Override//Delete
    public void deleteSalary(String idNo) {
     try {
        salaryDAO.delete (idNo);
    }catch (Exception e){
        Logger.getLogger("lk.sliit.project.employeeManagement.service.custom.impl").log(Level.SEVERE, null,e); //Add Logger To Catch Exception
    }
    }


    @Override //Find all Salary in the Salary Table
    @Transactional(readOnly = true)
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
    }//End Find all Salary in the Salary Table
}//End Class
