package lk.sliit.project.employeeManagement.controller.userDashboard;

import lk.sliit.project.employeeManagement.controller.SuperController;
import lk.sliit.project.employeeManagement.dto.AttendanceDTO;
import lk.sliit.project.employeeManagement.dto.EmployeeDTO;
import lk.sliit.project.employeeManagement.dto.NoticeDTO;
import lk.sliit.project.employeeManagement.service.custom.AttendanceBO;
import lk.sliit.project.employeeManagement.service.custom.DashboardBO;
import lk.sliit.project.employeeManagement.service.custom.EmployeeBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

@Controller
public class UserDashboard {

    @Autowired
    private DashboardBO dashboardBO;
    @Autowired
    AttendanceBO attendanceBO;
    @Autowired
    private EmployeeBO employeeBO;

    @GetMapping("/userDashboard")
    public ModelAndView loadMedia_galleryJSP(Model model ,@ModelAttribute EmployeeDTO employee) throws ServletException,IllegalStateException, IOException {
        //Get Male Count in Dashboard
        long maleCount = (dashboardBO.getMaleCount ( ));

        //Get AllEmployeeCount  in Dashboard
        long totalCount = dashboardBO.getAllEmployeeCount ( );

        //Get FemaleCount in Dashboard
        long femaleCount = dashboardBO.getFemaleCount ( );

        //Get All Employees in Dashboard
        model.addAttribute ( "empData", employeeBO.findAllEmployees ( ) );

        //Show Today attendance in Dashboard
        List<AttendanceDTO> attendanceDTOS =attendanceBO.findTodayAttendance ( );
        int count =0;
        for (AttendanceDTO attendanceDTO: attendanceDTOS) { count++; }
        model.addAttribute ( "todayAttendance", attendanceDTOS );

        //Show Upcoming BirthDays in Dashboard
        model.addAttribute ( "closingProjects", dashboardBO.projectsExp ( ) );

        //Show Notice
        List<NoticeDTO> p =  dashboardBO.findResentNoticeDesc();
        model.addAttribute ( "findAllNoticea", p );

        //Show Total Hours
        model.addAttribute ( "totalTime", (dashboardBO.getTotalTime ( )));

        //Show Total Projects
        model.addAttribute ( "totalProjects", (dashboardBO.getTotalProjects ( )));

        //Show Today Attendance Count
        model.addAttribute ( "todayAttendanceCount", count);

        //Set A Value If Male, Female, employee Count = null (Gender Is Varchar)
        if (maleCount > 0) model.addAttribute ( "maleCountDashBoard", maleCount );
        else model.addAttribute ( "maleCountDashBoard", 0 );

        if (totalCount > 0) model.addAttribute ( "employeeCountDashBoard", totalCount );
        else model.addAttribute ( "employeeCountDashBoard", 0 );

        if (femaleCount > 0) model.addAttribute ( "femaleCountDashBoard", femaleCount );
        else model.addAttribute ( "femaleCountDashBoard", 0 );

        //get Logged employee
        model.addAttribute ( "loggerName", employeeBO.getEmployeeByIdNo ( SuperController.idNo ) );
        ModelAndView mav = new ModelAndView ("userDashboard");
        return mav;
    }
}
