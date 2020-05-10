package lk.sliit.project.employeeManagement.controller.employee;


import lk.sliit.project.employeeManagement.service.custom.EmployeeBO;
import lk.sliit.project.employeeManagement.controller.SuperController;
import lk.sliit.project.employeeManagement.dto.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;

/**
 * @author: Minula
 * Date: 08-Mar-20
 */
@Controller
public class EmployeeController {//table_dynamic.jsp Page Controller

    @Autowired
    private EmployeeBO employeeBO;

    //Load All Employees to the Table In the tables_dynamic.jsp
    @RequestMapping("tables_dynamic")
    public ModelAndView loadTables_dynamicJSP(Model model,@ModelAttribute EmployeeDTO employee) {
        ModelAndView mav = new ModelAndView ( "tables_dynamic" );
        //Get All Employees
        mav.addObject ( "listEmployeesTable", employeeBO.findAllEmployees ( ) );
       //Get Logger User Data
        model.addAttribute ( "loggerName", employeeBO.getEmployeeByIdNo( SuperController.idNo) );
        return mav;
    }

    //Delete employee in the Table tables_dynamic.jsp
    @RequestMapping("delete")
    public String deleteEmployee(@RequestParam String idNo, HttpServletRequest request) {
        employeeBO.deleteUser ( idNo );
        //Get All Employees After Delete
        request.setAttribute ( "listEmployeesTable", employeeBO.findAllEmployees ( ) );
        return "redirect:/tables_dynamic";
    }
}//End Class
