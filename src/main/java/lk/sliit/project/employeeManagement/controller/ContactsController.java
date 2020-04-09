package lk.sliit.project.employeeManagement.controller;

import lk.sliit.project.employeeManagement.business.custom.EmployeeBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: Rivindu-Wijayarathna
 * Date: 22-Mar-20
 */
@Controller
public class ContactsController {
    @Autowired
    EmployeeBO employeeBO;
    //Update Employee in the Table tables_dynamic.jsp + form_validation
    @RequestMapping("profiles")
    public String editUser(@RequestParam String idNo, Model model, HttpServletRequest request) {
         request.setAttribute ( "mode", "MODE_UPDATE" );
        model.addAttribute ( "loggerName", employeeBO.getEmployeeByIdNo(SuperController.idNo) );
        model.addAttribute ( "loggerNames", employeeBO.getEmployeeByIdNo(idNo) );
        return "profiles";
    }
}
