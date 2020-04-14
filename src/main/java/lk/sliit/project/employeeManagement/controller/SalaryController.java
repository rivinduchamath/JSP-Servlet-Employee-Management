package lk.sliit.project.employeeManagement.controller;

import lk.sliit.project.employeeManagement.business.custom.AttendanceBO;
import lk.sliit.project.employeeManagement.business.custom.EmployeeBO;
import lk.sliit.project.employeeManagement.business.custom.SalaryBO;
import lk.sliit.project.employeeManagement.dto.AttendanceDTO;
import lk.sliit.project.employeeManagement.dto.EmployeeDTO;
import lk.sliit.project.employeeManagement.entity.Attendance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
        mav.addObject ( "listEmployeesTable", employeeBO.findAllEmployees ( ) );
        mav.addObject ( "countEmployee", employeeBO.findAllEmployees ( ) );
        model.addAttribute ( "loggerName", employeeBO.getEmployeeByIdNo ( SuperController.idNo ) );
        return mav;

    }

    @PostMapping("salarySave")
    public String registerUser(@ModelAttribute EmployeeDTO employee, HttpServletRequest request, Model model) throws IOException {

        System.out.println (employee.getIdNo () );
        System.out.println (employee.getPaymentDueTo () );
        System.out.println (employee.getSalary () );
        System.out.println (employee.getTotalOtHours () );
        System.out.println (employee.getName () );
      //  salaryBO.updateSalary ( employee );
//        salaryBO.updateSalary ( employee.getIdNo () );
    return "redirect:/salary";
}

    }
