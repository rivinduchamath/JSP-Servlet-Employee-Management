package lk.sliit.project.employeeManagement.controller.profile;

import lk.sliit.project.employeeManagement.service.custom.EmployeeBO;
import lk.sliit.project.employeeManagement.controller.SuperController;
import lk.sliit.project.employeeManagement.dto.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
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
public class ProfileController {//profile.jsp Page Controller
    @Autowired
    EmployeeBO employeeBO;
    @RequestMapping("/profile")//If SomeOne Click Profile Load Loggers Profile
    public ModelAndView loadProfile(Model model, @ModelAttribute EmployeeDTO employee, HttpServletRequest request, HttpServletResponse response) throws ServletException,IllegalStateException, IOException {
        ModelAndView mav = new ModelAndView ( "profile" );
        //Get Logger Data
        model.addAttribute ( "loggerName", employeeBO.getEmployeeByIdNo( SuperController.idNo) );
        return mav;
    }
}//End Class
