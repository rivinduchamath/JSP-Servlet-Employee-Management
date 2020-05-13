package lk.sliit.project.employeeManagement.controller.salary;

import lk.sliit.project.employeeManagement.service.custom.EmployeeBO;
import lk.sliit.project.employeeManagement.service.custom.SalaryBO;
import lk.sliit.project.employeeManagement.controller.SuperController;
import lk.sliit.project.employeeManagement.dto.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: Chanuka
 * Date: 25-Apr-20
 */
@Controller
public class UpdateSalaryController { //updateSalary.JSP Page Controller
    @Autowired
    EmployeeBO employeeBO;
    @Autowired
    private SalaryBO salaryBO;

    @GetMapping("/updateSalary")//Load Update Salary
    public ModelAndView updateSalary(Model model, @ModelAttribute EmployeeDTO employee, HttpServletRequest request, HttpServletResponse response) throws ServletException, IllegalStateException, IOException {
        ModelAndView mav = new ModelAndView ( "updateSalary" );
       //load All Salry
        mav.addObject ( "listEmployeesTableSalarya", salaryBO.findAllSalary ( ) );
      //Logged User Name
        model.addAttribute ( "loggerName", employeeBO.getEmployeeByIdNo ( SuperController.idNo ) );
        return mav;
    }
}//End Class
