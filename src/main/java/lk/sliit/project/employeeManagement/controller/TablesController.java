package lk.sliit.project.employeeManagement.controller;

import javafx.scene.control.Alert;
import lk.sliit.project.employeeManagement.business.custom.AttendanceBO;
import lk.sliit.project.employeeManagement.business.custom.DashboardBO;
import lk.sliit.project.employeeManagement.business.custom.EmployeeBO;
import lk.sliit.project.employeeManagement.dto.AttendanceDTO;
import lk.sliit.project.employeeManagement.entity.Attendance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.swing.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author: Rivindu-Wijayarathna
 * Date: 20-Mar-20
 */
@Controller
public class TablesController {
    DateFormat dateFormat = new SimpleDateFormat ( "yyyy/MM/dd" );
    Date date = new Date ( );

    @Autowired
    EmployeeBO employeeBO;
    @Autowired
    DashboardBO dashboardBO;
    @Autowired
    AttendanceBO attendanceBO;

    @RequestMapping("tables")
    public ModelAndView index(Model model, @ModelAttribute AttendanceDTO attendance) {

        ModelAndView mav = new ModelAndView ( "tables" );
        //Get All In Attendance
        mav.addObject ( "listAttendance", attendanceBO.findTodayAttendance ( ) );
        //Get All Employees
        mav.addObject ( "listEmployeesTable", employeeBO.findAllEmployees ( ) );
        //Top Employee
        AttendanceDTO totalCount = attendanceBO.getEmployeeAttCount ( );
        try {
            model.addAttribute ( "genAttendanceId", totalCount.getPid ( ) + 1 );
        } catch (NullPointerException e) {
            model.addAttribute ( "genAttendanceId", 1 );
        }

        //For get Logger Name and Picture
        model.addAttribute ( "loggerName", employeeBO.getEmployeeByIdNo ( SuperController.idNo ) );
        return mav;
    }

    @RequestMapping(value = "tablesAdd", method = RequestMethod.POST)
    public String index2(@ModelAttribute AttendanceDTO attendance, Model model) {
//        ModelAndView mav = new ModelAndView ( "tables" );
        DateFormat dateFormat = new SimpleDateFormat ( "yyyy/MM/dd" );
        Date date = new Date ( );
        attendance.setDate ( date );
        List <AttendanceDTO> todayAttendance = null;
        String dtId = "";
        try {
             dtId = attendance.getEmployeeID ( );
        }catch (NullPointerException e){

            return "redirect:/tables";
        }

        String id = "";
        todayAttendance = attendanceBO.findTodayAttendance ( );
        for (AttendanceDTO a : todayAttendance) {
            id = a.getEmployeeID ( );
            if (id.equals ( dtId )) {

                return "redirect:/tables";
            }
        }

        attendanceBO.save ( attendance );
        return "redirect:/tables";
    }

}