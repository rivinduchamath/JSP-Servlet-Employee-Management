package lk.sliit.project.employeeManagement.controller.projects;

import lk.sliit.project.employeeManagement.service.custom.EmployeeBO;
import lk.sliit.project.employeeManagement.service.custom.ProjectActivityBO;
import lk.sliit.project.employeeManagement.service.custom.ProjectBO;
import lk.sliit.project.employeeManagement.controller.SuperController;
import lk.sliit.project.employeeManagement.dto.ProjectActivityDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author: KV
 * Date: 15-Apr-20
 */
@Controller
public class ProjectDetailsEditController {//project_detail_Edit.jsp Controller
    @Autowired
    ProjectBO projectBO;
    @Autowired
    ProjectActivityBO projectActivityBO;
    @Autowired
    EmployeeBO employeeBO;

    @RequestMapping("/project_detail_Edit")
    public ModelAndView projectDetailEdit(Model model )  {
        ModelAndView mav = new ModelAndView ( "project_detail_Edit" );
        //Get Data From Stored Project Id
        model.addAttribute ( "projectData", projectBO.findProject (  SuperController.projectId  ) );
        // Get logged employee Data
        model.addAttribute ( "loggerName", employeeBO.getEmployeeByIdNo(SuperController.idNo) );
        try {
            //If Project Hasn't Any Activity
            model.addAttribute ( "loadActivity", projectActivityBO.loadProjectActivity(SuperController.projectId) );
        }catch (NullPointerException e){
            System.out.println ("No Project activities Found" );
        }
        return mav;
    }

    //Add New Activities
    @RequestMapping("saveActivities")
    public String saveActivities(@ModelAttribute ProjectActivityDTO projectActivity) throws IOException {

        try {
            //Get Activity Id
            ProjectActivityDTO totalCount = projectActivityBO.getgenActivityIdCount ( );
            int q = Integer.parseInt ( totalCount.getActivityId () );
            int c= q+ 1 ;
            projectActivity.setActivityId ( String.valueOf ( c ) );
        } catch (NullPointerException e) {
              //Activity Count = 0 then assign 1
            projectActivity.setActivityId ( "1"  );
        }
        //Get Clicked Project Id To save
        projectActivity.setProjectsID ( SuperController.projectId );
        //Save
        projectActivityBO.save ( projectActivity );
        //Add Project Id to url If someone Refresh URL
        return "redirect:/project_detail?projectId="+SuperController.projectId;
    }

}//End Class
