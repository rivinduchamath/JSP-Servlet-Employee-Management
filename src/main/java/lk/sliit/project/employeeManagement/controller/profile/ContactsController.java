package lk.sliit.project.employeeManagement.controller.profile;

import lk.sliit.project.employeeManagement.service.custom.EmployeeBO;
import lk.sliit.project.employeeManagement.controller.SuperController;
import lk.sliit.project.employeeManagement.dto.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: Minula
 * Date: 22-Mar-20
 */
@Controller
public class ContactsController {//contacts.jsp Controller
    @Autowired
    EmployeeBO employeeBO;

    @RequestMapping("/contacts")//When Click contacts.jsp Page
    public ModelAndView loadContactsJSP(Model model, @ModelAttribute EmployeeDTO employee, HttpServletRequest request, HttpServletResponse response) throws ServletException,IllegalStateException, IOException {
        ModelAndView mav = new ModelAndView ( "contacts" );
        //Get All employee Count
        mav.addObject ( "countEmployee", employeeBO.findAllEmployees ( ) );
        try {
            //Get Logger Data
            model.addAttribute ( "loggerName", employeeBO.getEmployeeByIdNo ( SuperController.idNo ) );
        }catch (Exception e) {
            System.out.println ("Server Re-Started So, please LogIn" );
        }
        return mav;
    }

    @RequestMapping("profiles")// if Click View profile in Contact Jsp
    public String getClickedUserData(@RequestParam String idNo, Model model, HttpServletRequest request) {
         request.setAttribute ( "mode", "MODE_UPDATE" );
        //Get Logger Data
        model.addAttribute ( "loggerName", employeeBO.getEmployeeByIdNo(SuperController.idNo) );
        //Get Clicked employee Data
        model.addAttribute ( "loggerNames", employeeBO.getEmployeeByIdNo(idNo) );
        return "profiles";
    }

}//End Class
