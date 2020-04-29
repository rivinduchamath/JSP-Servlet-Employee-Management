package lk.sliit.project.employeeManagement.controller.attendance;

import lk.sliit.project.employeeManagement.controller.SuperController;
import lk.sliit.project.employeeManagement.dto.AttendanceDTO;
import lk.sliit.project.employeeManagement.service.custom.EmployeeBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author: Rivindu-Wijayarathna
 * Date: 29-Apr-20
 */
@Controller
public class AllAttendanceController {

    @Autowired
    EmployeeBO employeeBO;
    @GetMapping("allAttendance")
    public ModelAndView index(Model model, @ModelAttribute AttendanceDTO attendance) {
        ModelAndView mav = new ModelAndView ( "allAttendance" );
        model.addAttribute ( "loggerName", employeeBO.getEmployeeByIdNo ( SuperController.idNo ) );
        return mav;
    }
}
