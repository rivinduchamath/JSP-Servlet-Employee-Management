package lk.sliit.project.employeeManagement.controller.attendance;

import lk.sliit.project.employeeManagement.service.custom.AttendanceBO;
import lk.sliit.project.employeeManagement.service.custom.DashboardBO;
import lk.sliit.project.employeeManagement.service.custom.EmployeeBO;
import lk.sliit.project.employeeManagement.controller.SuperController;
import lk.sliit.project.employeeManagement.dto.AttendanceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author: Rivindu-Wijayarathna
 * Date: 20-Mar-20
 */
@Controller
public class AttendanceController { //attendance.jsp Page For Attendance Manage
    DateFormat dateFormat = new SimpleDateFormat ( "yyyy/MM/dd" );
    Date date = new Date ( );

    @Autowired
    EmployeeBO employeeBO;
    @Autowired
    DashboardBO dashboardBO;
    @Autowired
    AttendanceBO attendanceBO;

    @RequestMapping("attendance")
    public ModelAndView index(Model model, @ModelAttribute AttendanceDTO attendance) {

        ModelAndView mav = new ModelAndView ( "attendance" );
        //Get All In Attendance
        mav.addObject ( "listAttendance", attendanceBO.findTodayAttendance ( ) );
        //Get All Employees
        mav.addObject ( "listEmployeesTable", employeeBO.findAllEmployees ( ) );
        //Top employee

        try {
            AttendanceDTO totalCount = attendanceBO.getEmployeeAttCount ( );
            int x = Integer.parseInt ( totalCount.getAttendanceId ( ) )+ 1;
            model.addAttribute ( "genAttendanceId", x);
        } catch (NullPointerException e) {
            model.addAttribute ( "genAttendanceId", 1 );
        }
        //For get Logger Name and Picture
        model.addAttribute ( "loggerName", employeeBO.getEmployeeByIdNo ( SuperController.idNo ) );
        return mav;
    }

    @RequestMapping(value = "tablesAdd", method = RequestMethod.POST)
    public String index2(@ModelAttribute AttendanceDTO attendance, Model model) {
        DateFormat dateFormat = new SimpleDateFormat ( "yyyy/MM/dd" );
        Date date = new Date ( );
        attendance.setDate ( date );
        List <AttendanceDTO> todayAttendance = null;
        String dtId = "";
        String dtAId = "";
        String aId = "";
        String id = "";
        todayAttendance = attendanceBO.findTodayAttendance ( );
        try {
            dtId = attendance.getEmployeeID ( );
            dtAId = attendance.getAttendanceId ( );
        } catch (NullPointerException e) {

            return "redirect:/attendance";
        }
        for (AttendanceDTO a : todayAttendance) {
            id = a.getEmployeeID ( );
            aId = a.getAttendanceId ();
            if (id.equals ( dtId )) {
                attendance.setAttendanceId ( aId );
                attendanceBO.save ( attendance );
                return "redirect:/attendance";
            }
        }
        attendanceBO.save ( attendance );
        return "redirect:/attendance";
    }

    //Delete Attendance in the Table Attendance
    @RequestMapping("deleteAttendance")
    public String deleteUser(@RequestParam String pid, HttpServletRequest request) {
        attendanceBO.deleteUser ( pid );
        //Get All Employees After Delete
        request.setAttribute ( "listEmployeesTable", employeeBO.findAllEmployees ( ) );
        return "redirect:/attendance";
    }


}