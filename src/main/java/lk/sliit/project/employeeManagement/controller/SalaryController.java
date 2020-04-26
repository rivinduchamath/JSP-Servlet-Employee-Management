package lk.sliit.project.employeeManagement.controller;

import lk.sliit.project.employeeManagement.business.custom.AttendanceBO;
import lk.sliit.project.employeeManagement.business.custom.EmployeeBO;
import lk.sliit.project.employeeManagement.business.custom.SalaryBO;
import lk.sliit.project.employeeManagement.dto.EmployeeDTO;
import lk.sliit.project.employeeManagement.dto.SalaryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author: Rivindu-Wijayarathna
 * Date: 13-Apr-20
 */
@Controller
public class SalaryController {
    @Autowired
    private SalaryBO salaryBO;
    @Autowired
    private AttendanceBO attendanceBO;
    @Autowired
    private EmployeeBO employeeBO;

    @RequestMapping("salary")
    public ModelAndView index(Model model, @ModelAttribute EmployeeDTO employee, HttpServletRequest
            request, HttpServletResponse response) throws ServletException, IllegalStateException, IOException {
        ModelAndView mav = new ModelAndView ( "salary" );
        mav.addObject ( "listEmployeesTableSalary", salaryBO.findAllSalary ( ) );
        mav.addObject ( "listEmployeesTable", employeeBO.findAllEmployees ( ) );
        List<SalaryDTO> salaryDTOS =salaryBO.findAllSalary ( );

        int i =0;
        for (SalaryDTO e: salaryDTOS) {
            i++;
        }
        mav.addObject ( "countEmployee2", i );
        model.addAttribute ( "loggerName", employeeBO.getEmployeeByIdNo ( SuperController.idNo ) );
        return mav;

    }

    @PostMapping("salarySave")
    public String registerUser(@ModelAttribute SalaryDTO salaryDTO) throws IOException {
        salaryDTO.setSalaryId ("S"+ salaryDTO.getEmployeeID ().getIdNo () );
        salaryBO.updateSalary ( salaryDTO );
    return "redirect:/salary";
}

    //Delete Employee in the Table tables_dynamic.jsp
    @RequestMapping("deleteSalary")
    public String deleteUser(@RequestParam String idNo, HttpServletRequest request) {
        salaryBO.deleteSalary ( idNo );
        return "redirect:/salary";
    }


    @RequestMapping("invoice")
    public ModelAndView index2(@ModelAttribute SalaryDTO salaryDTO, Model model) {
        ModelAndView mav = new ModelAndView ( "invoice" );

        model.addAttribute ( "loggerName", employeeBO.getEmployeeByIdNo(SuperController.idNo) );
        model.addAttribute ( "getSalaryData",  salaryBO.getSalaryData(salaryDTO.getSalaryId ()));
        return mav;
    }
    //Delete Employee in the Table tables_dynamic.jsp

    }
