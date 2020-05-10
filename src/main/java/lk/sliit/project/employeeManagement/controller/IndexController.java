package lk.sliit.project.employeeManagement.controller;

import lk.sliit.project.employeeManagement.dto.AttendanceDTO;
import lk.sliit.project.employeeManagement.dto.NoticeDTO;
import lk.sliit.project.employeeManagement.service.custom.AttendanceBO;
import lk.sliit.project.employeeManagement.service.custom.DashboardBO;
import lk.sliit.project.employeeManagement.service.custom.EmployeeBO;
import lk.sliit.project.employeeManagement.dto.EmployeeDTO;
import lk.sliit.project.employeeManagement.service.custom.NoticeBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

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
    @Autowired
    private NoticeBO noticeBO;
    //Initial Load Page http://localhost:8091/login
    @Scope(scopeName = "")
    @GetMapping("/login")
    public String index_Login(HttpServletRequest request) {
        request.setAttribute ( "mode", "MODE_LOGIN" );
        return "index";
    }

    //Initial Load Page http://localhost:8091
    @GetMapping("/")
    public String index(HttpServletRequest request) {
        request.setAttribute ( "mode", "MODE_LOGIN" );
        return "index";
    }

    @PostMapping("Dashboard") // Load dashboard.jsp Page If Id And password is mach
    public String loadDashBoard(@ModelAttribute EmployeeDTO employee, HttpServletRequest request, Model model) throws IOException {
        //True If Id and password is match
        if (dashboardBO.findByIdNoAndPassword ( employee.getIdNo ( ), employee.getPassword ( ) ) != null) {
            //Get Male Count
            long maleCount = (dashboardBO.getMaleCount ( ));
            //Get All employee Count
            long totalCount = (dashboardBO.getAllEmployeeCount ( ));
            //Get Female Count
            long femaleCount = dashboardBO.getFemaleCount ( );

            //Get Today Attendance
            List<AttendanceDTO> attendanceDTOS =attendanceBO.findTodayAttendance ( );
           int count =0;
            for (AttendanceDTO attendanceDTO: attendanceDTOS) {
                count++;
            }
            model.addAttribute ( "todayAttendance",attendanceDTOS );
            //Get Upcoming Birth days(1 Month ahead )
            model.addAttribute ( "upcomingBitrhDays", dashboardBO.upcomingBirthDays ( ) );
            List<NoticeDTO> p =  dashboardBO.findAllNoticeDesc();
            model.addAttribute ( "findAllNoticea", p );

            model.addAttribute ( "totalTime", (dashboardBO.getTotalTime ( )));
            model.addAttribute ( "totalProjects", (dashboardBO.getTotalProjects ( )));
            model.addAttribute ( "todayAttendanceCount", count);
                    //Set A Value If Male, Female, employee Count = null (Gender Is Varchar)
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
