package lk.sliit.project.employeeManagement.controller;

import lk.sliit.project.employeeManagement.business.custom.AttendanceBO;
import lk.sliit.project.employeeManagement.business.custom.DashboardBO;
import lk.sliit.project.employeeManagement.business.custom.EmployeeBO;
import lk.sliit.project.employeeManagement.dto.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author: Rivindu-Wijayarathna
 * Date: 08-Mar-20
 */
@Controller
public class IndexController {
    @Autowired
    EmployeeBO employeeBO;
    @Autowired
    DashboardBO dashboardBO;
    @Autowired
    AttendanceBO attendanceBO;

    //Initial Load Page http://localhost:8091
    @Scope(scopeName = "")
    @RequestMapping("/login")
    public String index(HttpServletRequest request) {
        request.setAttribute("mode", "MODE_LOGIN");
        return "index";
    }
    @RequestMapping("/")
    public String indexa(HttpServletRequest request) {
        request.setAttribute("mode", "MODE_LOGIN");
        return "index";
    }

/////////////
    @PostMapping("Dashboard")
    public String registerUser(@ModelAttribute EmployeeDTO employee, HttpServletRequest request, Model model) throws IOException {
        if (employeeBO.findByIdNoAndPassword ( employee.getIdNo ( ), employee.getPassword ( ) ) != null) {
            long maleCount = ( dashboardBO.getMaleCount ( ) );
            long totalCount = ( dashboardBO.getAllEmployeeCount ( ) );
            long femaleCount = dashboardBO.getFemaleCount ();

            model.addAttribute ( "todayAttendance", attendanceBO.findTodayAttendance ( ) );
            model.addAttribute ( "upcomingBitrhDays", employeeBO.upcomingBirthDays ( ) );
            if (maleCount > 0) model.addAttribute ( "maleCountDashBoard", maleCount );
            else model.addAttribute ( "maleCountDashBoard", 0 );


            if (totalCount > 0) model.addAttribute ( "employeeCountDashBoard", totalCount );
            else model.addAttribute ( "employeeCountDashBoard", 0 );

            if (femaleCount > 0) model.addAttribute ( "femaleCountDashBoard", femaleCount );
            else model.addAttribute ( "femaleCountDashBoard", 0 );
             SuperController.idNo = employee.getIdNo ();
             model.addAttribute ( "loggerName", employeeBO.getEmployeeByIdNo(SuperController.idNo) );

            return "/Dashboard";
        } else {
            return "redirect:/login";
        }
    }
}
