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
import javax.servlet.http.HttpServlet;

/**
 * @author: Rivindu-Wijayarathna
 * Date: 08-Mar-20
 */
@Controller
public class DashboardController extends HttpServlet { //dashboard.jsp Page Controller

    private static final long serialVersionUID = 1L;
    @Autowired
    AttendanceBO attendanceBO;
    //Automate Object Creation
    @Autowired
    private DashboardBO dashboardBO;
    @Autowired
    private EmployeeBO employeeBO;

    //Find Total Employee Count For DashBoard
    @RequestMapping("/Dashboard")  //Control dashboard.jsp Page
    public void dashboard(Model model, @ModelAttribute EmployeeDTO employee) {
        DashBoardLoad ( model, employee );
    }

    String DashBoardLoad(Model model, EmployeeDTO employee) {
        //Get Male Count in Dashboard
        long maleCount = (dashboardBO.getMaleCount ( ));
        //Get AllEmployeeCount  in Dashboard
        long totalCount = dashboardBO.getAllEmployeeCount ( );
        //Get FemaleCount in Dashboard
        long femaleCount = dashboardBO.getFemaleCount ( );
        //Get All Employees in Dashboard
        model.addAttribute ( "empData", employeeBO.findAllEmployees ( ) );
        //Show Today attendance in Dashboard
        model.addAttribute ( "todayAttendance", attendanceBO.findTodayAttendance ( ) );
        //Show Upcoming BirthDays in Dashboard
        model.addAttribute ( "upcomingBitrhDays", employeeBO.upcomingBirthDays ( ) );

        //Set A Value If Male, Female, Employee Count = null (Gender Is Varchar)
        if (maleCount > 0) model.addAttribute ( "maleCountDashBoard", maleCount );
        else model.addAttribute ( "maleCountDashBoard", 0 );

        if (totalCount > 0) model.addAttribute ( "employeeCountDashBoard", totalCount );
        else model.addAttribute ( "employeeCountDashBoard", 0 );

        if (femaleCount > 0) model.addAttribute ( "femaleCountDashBoard", femaleCount );
        else model.addAttribute ( "femaleCountDashBoard", 0 );

        //get Logged Employee
        model.addAttribute ( "loggerName", employeeBO.getEmployeeByIdNo ( SuperController.idNo ) );
        return "Dashboard";
    }
}
