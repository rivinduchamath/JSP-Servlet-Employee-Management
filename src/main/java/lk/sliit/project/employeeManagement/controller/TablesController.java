package lk.sliit.project.employeeManagement.controller;

import com.mysql.jdbc.Wrapper;
import lk.sliit.project.employeeManagement.business.custom.DashboardBO;
import lk.sliit.project.employeeManagement.business.custom.EmployeeBO;
import lk.sliit.project.employeeManagement.dto.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;

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

    @RequestMapping("tables")
    public ModelAndView index(Model model,@ModelAttribute EmployeeDTO employee) {
        ModelAndView mav = new ModelAndView ( "tables" );
        mav.addObject ( "listEmployeesTable", employeeBO.findAllEmployees ( ) );
        long totalCount =  dashboardBO.getEmployeeAttCount ( );
        if (totalCount > 0) model.addAttribute ( "genAttendanceId", (totalCount+1) );
        else model.addAttribute ( "genAttendanceId", 0 );
        model.addAttribute ( "loggerName", employeeBO.getEmployeeByIdNo(SuperController.idNo) );
        return mav;
    }


}
