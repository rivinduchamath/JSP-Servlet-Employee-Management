package lk.sliit.project.employeeManagement.controller.salary;

import lk.sliit.project.employeeManagement.service.custom.EmployeeBO;
import lk.sliit.project.employeeManagement.service.custom.SalaryBO;
import lk.sliit.project.employeeManagement.controller.SuperController;
import lk.sliit.project.employeeManagement.dto.EmployeeDTO;
import lk.sliit.project.employeeManagement.dto.SalaryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

/**
 * @author: Chanuka
 * Date: 13-Apr-20
 */
@Controller
public class SalaryController { //salary.jsp to Manage Salary
    @Autowired
    private SalaryBO salaryBO;
    @Autowired
    private EmployeeBO employeeBO;

    @GetMapping("salary")//Load Salary JSP Page
    public ModelAndView loadSalaryJSP(Model model, @ModelAttribute EmployeeDTO employee) throws IllegalStateException {

        ModelAndView mav = new ModelAndView ( "salary" );
        //Load All employee to a Table With their Total Salary
        mav.addObject ( "listEmployeesTableSalary", salaryBO.findAllSalary ( ) );
        //Load All employee to a Table
        mav.addObject ( "listEmployeesTable", employeeBO.findAllEmployees ( ) );

        //Get All Data In Salary Table
        List <SalaryDTO> salaryDTOS = salaryBO.findAllSalary ( );
        int i = 0;
        for (SalaryDTO e : salaryDTOS) {
            i++; // Get Count
        }
        //Pass Salary Row Count
        mav.addObject ( "countEmployee2", i );
        //Get Logged employee Id
        model.addAttribute ( "loggerName", employeeBO.getEmployeeByIdNo ( SuperController.idNo ) );
        return mav;

    }

    @PostMapping("salarySave")//Save Or Update Salary
    public String saveOrUpdateSalary(@ModelAttribute SalaryDTO salaryDTO) {
        //Take Salary Id As EmployeeId + S
        salaryDTO.setSalaryId ( "S" + salaryDTO.getEmployeeID ( ).getIdNo ( ) );
        //Calling Update Method
        salaryBO.saveOrUpdateSalary ( salaryDTO );
        return "redirect:/salary";
    }

    //Delete employee in the Table When Click Delete Icon
    @RequestMapping("deleteSalary")
    public String deleteSalary(@RequestParam String idNo) {
        salaryBO.deleteSalary ( idNo );
        return "redirect:/salary";
    }

}//End Class
