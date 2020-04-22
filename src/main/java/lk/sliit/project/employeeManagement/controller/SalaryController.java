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
        mav.addObject ( "listAttendance", attendanceBO.findTodayAttendance ( ) );
        mav.addObject ( "listEmployeesTableSalary", salaryBO.findAllSalary ( ) );
        List<EmployeeDTO> employeeDTOS =employeeBO.findAllEmployees ( );
        mav.addObject ( "countEmployee", employeeDTOS);
        int i =0;
        for (EmployeeDTO e: employeeDTOS) {
            i++;
        }
        mav.addObject ( "countEmployee2", i );
        model.addAttribute ( "loggerName", employeeBO.getEmployeeByIdNo ( SuperController.idNo ) );
        return mav;

    }

    @PostMapping("salarySave")
    public String registerUser(@ModelAttribute SalaryDTO salaryDTO, HttpServletRequest request, Model model) throws IOException {


        System.out.println (salaryDTO.getSalaryId () );

        salaryBO.updateSalary ( salaryDTO );
//        salaryBO.updateSalary ( employee.getIdNo () );
    return "redirect:/salary";
}

    @RequestMapping("invoice")
    public ModelAndView index2(@ModelAttribute SalaryDTO salaryDTO, Model model) {
        ModelAndView mav = new ModelAndView ( "invoice" );
        System.out.println (salaryDTO.getSalaryId () );
        System.out.println (salaryDTO.getTotalOtHours () );
        model.addAttribute ( "loggerName", employeeBO.getEmployeeByIdNo(SuperController.idNo) );
        model.addAttribute ( "getSalaryData",  salaryBO.getSalaryData(salaryDTO.getSalaryId ()));
        return mav;
    }
    }
