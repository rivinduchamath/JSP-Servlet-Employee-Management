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
import java.util.logging.Level;
import java.util.logging.Logger;

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

    @RequestMapping("attendance")//Load attendance.jsp Page
    public ModelAndView loadAttendance(Model model, @ModelAttribute AttendanceDTO attendance) {

        ModelAndView mav = new ModelAndView ( "attendance" );
        //Get All In Attendance
        mav.addObject ( "listAttendance", attendanceBO.findTodayAttendance ( ) );
        //Get All Employees
        mav.addObject ( "listEmployeesTable", employeeBO.findAllEmployees ( ) );

        try {
            AttendanceDTO totalCount = attendanceBO.findTopByOrderByAttendanceIdDesc ( );
            int x = Integer.parseInt ( totalCount.getAttendanceId ( ) )+ 1;
            model.addAttribute ( "genAttendanceId", x);
        } catch (NullPointerException e) {
            model.addAttribute ( "genAttendanceId", 1 );
        }
        //For get Logger Name and Picture
        model.addAttribute ( "loggerName", employeeBO.getEmployeeByIdNo ( SuperController.idNo ) );
        return mav;
    }//End loadAttendance Method

    //Add Only Today Attendance
    // (One Employee Can add attendance One time Per Day, If SomeOne Going to add Again It will Be Update)
    @RequestMapping(value = "tablesAdd", method = RequestMethod.POST)
    public String addTodayAttendance(@ModelAttribute AttendanceDTO attendance, Model model) {
        DateFormat dateFormat = new SimpleDateFormat ( "yyyy/MM/dd" );
        Date date = new Date ( ); //Get Date
        attendance.setDate ( date ); //set today Date
        List <AttendanceDTO> todayAttendance = null;
        String eId = "";
        String attendanceID = "";
        String employeeID = "";
        todayAttendance = attendanceBO.findTodayAttendance ( );//Get All Today Attendance

        try {
            eId = attendance.getEmployeeID ( );//add EmployeeID From JSP
        } catch (NullPointerException e) {
            Logger.getLogger("lk.sliit.project.employeeManagement").log(Level.SEVERE, null,e); //Add Logger To Catch NullPointerException
            return "redirect:/attendance";//If NullPointerException, Reload Attendance.jsp
        }
        for (AttendanceDTO a : todayAttendance) {
            employeeID = a.getEmployeeID ( );//add EmployeeID From Attendance
            attendanceID = a.getAttendanceId ();//add AttendanceId From Attendance
            if (employeeID.equals ( eId )) {//Check JSP Employee ID Already in today attendance
                attendance.setAttendanceId ( attendanceID ); //IF true Set Attendance Id and save
                attendanceBO.saveOrUpdate ( attendance );
                return "redirect:/attendance";
            }
        }
        attendanceBO.saveOrUpdate ( attendance );//Else Attendance Save Under Previous Attendance ID
        return "redirect:/attendance";
    }//End addTodayAttendance Method

    //Delete Attendance in the Table Attendance
    @RequestMapping("deleteAttendance")
    public String deleteUserAttendance(@RequestParam String pid, HttpServletRequest request) {
        attendanceBO.deleteAttendance ( pid );
        //Get All Employees After Delete
        request.setAttribute ( "listEmployeesTable", employeeBO.findAllEmployees ( ) );
        return "redirect:/attendance";
    }
}//End Class