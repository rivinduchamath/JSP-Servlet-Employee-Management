package lk.sliit.project.employeeManagement.controller.salary;

import lk.sliit.project.employeeManagement.service.custom.EmployeeBO;
import lk.sliit.project.employeeManagement.service.custom.SalaryBO;
import lk.sliit.project.employeeManagement.controller.SuperController;
import lk.sliit.project.employeeManagement.dto.SalaryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author: Chanuka
 * Date: 26-Apr-20
 */
@Controller
public class InvoiceController { //invoice.jsp Page Controller
    @Autowired
    private SalaryBO salaryBO;
    @Autowired
    private EmployeeBO employeeBO;

    @RequestMapping("invoice")//Goto Invoice Page From salary.jsp Page When Click Pay Button
    public ModelAndView loadInvoicePage(@ModelAttribute SalaryDTO salaryDTO, Model model) {
        ModelAndView mav = new ModelAndView ( "invoice" );
        //Get Logged Customer Data
        model.addAttribute ( "loggerName", employeeBO.getEmployeeByIdNo ( SuperController.idNo ) );
        //Get Only Check Box Clicked Data
        model.addAttribute ( "getSalaryData", salaryBO.getSalaryData ( salaryDTO.getSalaryId ( ) ) );
        return mav;
    }

    //If Someone Refresh URL Top Again Load Invoice Page Without any Data
    @GetMapping("invoice")
    public String getInvoiceEmpty() {
        return "invoice";
    }


    @PostMapping("deleteInvoiceSalary")//When Payment Is Complete Delete Salary Data Which Clicked
    public String deleteSalary(@ModelAttribute SalaryDTO salaryDTO, Model model) {
        //Pass All Data as a String And Add Only Salary Id To a String array
        String[] sourceAry = salaryDTO.getSalaryId ( ).split ( " " );

        //Delete Salary From Salary Table
        for (String s : sourceAry) {
            salaryBO.deleteSalary ( s );
        }
        return "redirect:/salary";
    }//End Delete Method
}//End Class
