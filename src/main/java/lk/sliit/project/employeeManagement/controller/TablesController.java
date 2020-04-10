package lk.sliit.project.employeeManagement.controller;

import lk.sliit.project.employeeManagement.business.custom.AttendanceBO;
import lk.sliit.project.employeeManagement.business.custom.DashboardBO;
import lk.sliit.project.employeeManagement.business.custom.EmployeeBO;
import lk.sliit.project.employeeManagement.dao.AttendanceDAO;
import lk.sliit.project.employeeManagement.dto.AttendanceDTO;
import lk.sliit.project.employeeManagement.dto.EmployeeDTO;
import lk.sliit.project.employeeManagement.entity.Attendance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author: Rivindu-Wijayarathna
 * Date: 20-Mar-20
 */
@Controller
public class TablesController {
    @Autowired
    EmployeeBO employeeBO;
    @Autowired
    DashboardBO dashboardBO;
    @Autowired
    AttendanceBO attendanceBO;


    @RequestMapping("tables")
    public ModelAndView index(Model model,@ModelAttribute AttendanceDTO attendance) {

        ModelAndView mav = new ModelAndView ( "tables" );
        //Get All In Attendance
        mav.addObject ( "listAttendance", attendanceBO.findtodayAttendence ( )  );
       //Get All Employees
        mav.addObject ( "listEmployeesTable", employeeBO.findAllEmployees ()  );
       //Top Employee
        Attendance totalCount =  attendanceBO.getEmployeeAttCount ( );
 try {
     model.addAttribute ( "genAttendanceId", totalCount.getPid ( ) + 1 );
 }catch (NullPointerException e){
     model.addAttribute ( "genAttendanceId", 1 );
 }

        //For get Logger Name and Picture
        model.addAttribute ( "loggerName", employeeBO.getEmployeeByIdNo(SuperController.idNo) );
        return mav;
    }
    @RequestMapping("tablesAdd")
    public String index2(Model model,@ModelAttribute AttendanceDTO attendance) {
      attendanceBO.save ( attendance );
        return "redirect:/tables";
    }

}
