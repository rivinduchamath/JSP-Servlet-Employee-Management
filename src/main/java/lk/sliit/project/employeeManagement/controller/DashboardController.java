package lk.sliit.project.employeeManagement.controller;

import lk.sliit.project.employeeManagement.business.custom.AttendanceBO;
import lk.sliit.project.employeeManagement.business.custom.DashboardBO;
import lk.sliit.project.employeeManagement.business.custom.EmployeeBO;
import lk.sliit.project.employeeManagement.dto.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: Rivindu-Wijayarathna
 * Date: 08-Mar-20
 */
@Controller
public class DashboardController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    //Automate Object Creation
    @Autowired
    private DashboardBO dashboardBO;
    @Autowired
    private EmployeeBO employeeBO;
    @Autowired
    AttendanceBO attendanceBO;
    //Find Total Employee Count For DashBoard
    @RequestMapping("/Dashboard")
    public void dashboard(Model model,@ModelAttribute EmployeeDTO employee) {
       DashBoardLoad ( model ,employee);
    }
    ////////////////////////////////
    String DashBoardLoad(Model model, EmployeeDTO employee){
        long maleCount = ( dashboardBO.getMaleCount ( ) );
        long totalCount =  dashboardBO.getAllEmployeeCount ( );
        long femaleCount =  dashboardBO.getFemaleCount();
        model.addAttribute ( "empData", employeeBO.findAllEmployees ( ) );
        model.addAttribute ( "todayAttendance", attendanceBO.findTodayAttendance ( ) );
        model.addAttribute ( "upcomingBitrhDays", employeeBO.upcomingBirthDays ( ) );
        if (maleCount > 0) model.addAttribute ( "maleCountDashBoard", maleCount );
        else model.addAttribute ( "maleCountDashBoard", 0 );

        if (totalCount > 0) model.addAttribute ( "employeeCountDashBoard", totalCount );
        else model.addAttribute ( "employeeCountDashBoard", 0 );

        if (femaleCount > 0) model.addAttribute ( "femaleCountDashBoard", femaleCount );
        else model.addAttribute ( "femaleCountDashBoard", 0 );

        model.addAttribute ( "loggerName", employeeBO.getEmployeeByIdNo(SuperController.idNo) );
        return "Dashboard";
    }

    @RequestMapping("/contacts")
    public ModelAndView index(Model model,@ModelAttribute EmployeeDTO employee,HttpServletRequest request, HttpServletResponse response) throws ServletException,IllegalStateException, IOException {
        ModelAndView mav = new ModelAndView ( "contacts" );
        mav.addObject ( "countEmployee", employeeBO.findAllEmployees ( ) );
       try {
           model.addAttribute ( "loggerName", employeeBO.getEmployeeByIdNo ( SuperController.idNo ) );
       }catch (Exception e) {
           System.out.println ("Server Re-Started So, please LogIn" );
       }
        return mav;

    }

//
}
