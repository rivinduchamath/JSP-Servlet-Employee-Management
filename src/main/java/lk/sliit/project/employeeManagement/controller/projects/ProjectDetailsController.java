package lk.sliit.project.employeeManagement.controller.projects;

import lk.sliit.project.employeeManagement.business.custom.EmployeeBO;
import lk.sliit.project.employeeManagement.business.custom.ProjectActivityBO;
import lk.sliit.project.employeeManagement.business.custom.ProjectBO;
import lk.sliit.project.employeeManagement.controller.SuperController;
import lk.sliit.project.employeeManagement.dto.ProjectActivityDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author: Rivindu-Wijayarathna
 * Date: 15-Apr-20
 */
@Controller
public class ProjectDetailsController {//project_detail.jsp Page Controller
    @Autowired
    ProjectBO projectBO;
    @Autowired
    ProjectActivityBO projectActivityBO;
    @Autowired
    EmployeeBO employeeBO;

    @RequestMapping("project_detail")//Get Clicked Project Details
    public String project_details(@RequestParam String projectId, Model model, HttpServletRequest request){
        SuperController.projectId = projectId;
        model.addAttribute ( "projectData", projectBO.findProject ( projectId ) );
       //Logger Data
        model.addAttribute ( "loggerName", employeeBO.getEmployeeByIdNo(SuperController.idNo) );
        try {
            //Load All Activity
            model.addAttribute ( "loadActivity", projectActivityBO.loadProjectActivity(SuperController.projectId) );
        }catch (NullPointerException e){
            System.out.println ("No Project activities Found" );
        }
        return "project_detail";
    }

}
