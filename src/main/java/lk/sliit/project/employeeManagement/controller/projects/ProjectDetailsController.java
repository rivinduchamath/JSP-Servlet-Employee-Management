package lk.sliit.project.employeeManagement.controller.projects;

import lk.sliit.project.employeeManagement.service.custom.EmployeeBO;
import lk.sliit.project.employeeManagement.service.custom.ProjectActivityBO;
import lk.sliit.project.employeeManagement.service.custom.ProjectBO;
import lk.sliit.project.employeeManagement.controller.SuperController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author: KV
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

    @GetMapping("project_detail")//Get Clicked Project Details
    public String project_details(@RequestParam String projectId, Model model, HttpServletRequest request){
        SuperController.projectId = projectId;
        model.addAttribute ( "projectData", projectBO.findProject ( projectId ) );
       //Logger Data
        model.addAttribute ( "loggerName", employeeBO.getEmployeeByIdNo(SuperController.idNo) );
        try {
            //Load All Activity
            model.addAttribute ( "loadActivity", projectActivityBO.loadProjectActivity(SuperController.projectId) );
        }catch (NullPointerException e){
            Logger.getLogger("lk.sliit.project.employeeManagement").log(Level.SEVERE, null,e); //Add Logger To Catch NullPointerException
            System.out.println ("No Project activities Found" );
        }
        return "project_detail";
    }

}//End Class
