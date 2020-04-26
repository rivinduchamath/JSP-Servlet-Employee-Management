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
public class IndexController { //index.jsp Page Controller
    @Autowired
    EmployeeBO employeeBO;
    @Autowired
    DashboardBO dashboardBO;
    @Autowired
    AttendanceBO attendanceBO;

    //Initial Load Page http://localhost:8091/login
    @Scope(scopeName = "")
    @RequestMapping("/login")
    public String index(HttpServletRequest request) {
        request.setAttribute ( "mode", "MODE_LOGIN" );
        return "index";
    }

    //Initial Load Page http://localhost:8091
    @RequestMapping("/")
    public String indexa(HttpServletRequest request) {
        request.setAttribute ( "mode", "MODE_LOGIN" );
        return "index";
    }

    @PostMapping("Dashboard") // Load dashboard.jsp Page If Id And password is mach
    public String registerUser(@ModelAttribute EmployeeDTO employee, HttpServletRequest request, Model model) throws IOException {
        //True If Id and password is match
        if (employeeBO.findByIdNoAndPassword ( employee.getIdNo ( ), employee.getPassword ( ) ) != null) {
            //Get Male Count
            long maleCount = (dashboardBO.getMaleCount ( ));
            //Get All Employee Count
            long totalCount = (dashboardBO.getAllEmployeeCount ( ));
            //Get Female Count
            long femaleCount = dashboardBO.getFemaleCount ( );

            //Get Today Attendance
            model.addAttribute ( "todayAttendance", attendanceBO.findTodayAttendance ( ) );
            //Get Upcoming Birth days(1 Month ahead )
            model.addAttribute ( "upcomingBitrhDays", employeeBO.upcomingBirthDays ( ) );
            //Set A Value If Male, Female, Employee Count = null (Gender Is Varchar)
            if (maleCount > 0) model.addAttribute ( "maleCountDashBoard", maleCount );
            else model.addAttribute ( "maleCountDashBoard", 0 );

            if (totalCount > 0) model.addAttribute ( "employeeCountDashBoard", totalCount );
            else model.addAttribute ( "employeeCountDashBoard", 0 );

            if (femaleCount > 0) model.addAttribute ( "femaleCountDashBoard", femaleCount );
            else model.addAttribute ( "femaleCountDashBoard", 0 );

            //Add Logger Id To the static variable idNo
            SuperController.idNo = employee.getIdNo ( );
            //Get Logger Data
            model.addAttribute ( "loggerName", employeeBO.getEmployeeByIdNo ( SuperController.idNo ) );

            return "/Dashboard";
        } else {//If User name And Password is not match
            return "redirect:/login";
        }
    }//End method
}//End class
