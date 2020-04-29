package lk.sliit.project.employeeManagement.controller.projects;

import lk.sliit.project.employeeManagement.service.custom.EmployeeBO;
import lk.sliit.project.employeeManagement.service.custom.ProjectBO;
import lk.sliit.project.employeeManagement.controller.SuperController;
import lk.sliit.project.employeeManagement.dto.ProjectDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: Rivindu-Wijayarathna
 * Date: 23-Mar-20
 */
@Controller
public class ProjectsManageController {//projectController.jsp Controller
    @Autowired
    ProjectBO projectBO;
    @Autowired
    EmployeeBO employeeBO;


    @RequestMapping("/projectController") //Add New Project Go to MODE_REG
    public String projectsManage(HttpServletRequest request,@ModelAttribute ProjectDTO project) {
        request.setAttribute ( "mode", "MODE_REG" );
        return "projectController";
    }


    @RequestMapping("edit-project") // If Some One Click Edit Button Go To "MODE_UP"
    public String editUser(@RequestParam String projectId, Model model, HttpServletRequest request) {
       //Get add Clicked Project Data
        request.setAttribute ( "project", projectBO.findProject ( projectId ) );
        request.setAttribute ( "mode", "MODE_UP" );
        //Logger DAta
        model.addAttribute ( "loggerName", employeeBO.getEmployeeByIdNo( SuperController.idNo) );
        return "projectController";
    }





}
