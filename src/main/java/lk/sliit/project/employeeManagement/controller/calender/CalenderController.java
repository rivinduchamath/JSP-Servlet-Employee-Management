package lk.sliit.project.employeeManagement.controller.calender;

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
 * @author: Rivindu-Wijayarathna
 * Date: 22-Mar-20
 */
@Controller
public class CalenderController { //calender.jsp Page Controller
    @Autowired
    EmployeeBO employeeBO;
    @RequestMapping("/calendar")//Load Calender JSP Page
    public ModelAndView loadCalender(Model model, @ModelAttribute EmployeeDTO employee, HttpServletRequest request, HttpServletResponse response) throws ServletException,IllegalStateException, IOException {
        ModelAndView mav = new ModelAndView ( "calendar" );
        model.addAttribute ( "loggerName", employeeBO.getEmployeeByIdNo( SuperController.idNo) );
        return mav;
    }

}//End Class

