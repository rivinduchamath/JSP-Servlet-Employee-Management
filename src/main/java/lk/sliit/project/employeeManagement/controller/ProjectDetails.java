package lk.sliit.project.employeeManagement.controller;

import lk.sliit.project.employeeManagement.business.custom.EmployeeBO;
import lk.sliit.project.employeeManagement.business.custom.ProjectActivityBO;
import lk.sliit.project.employeeManagement.business.custom.ProjectBO;
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
public class ProjectDetails {
    @Autowired
    ProjectBO projectBO;
    @Autowired
    ProjectActivityBO projectActivityBO;
    @Autowired
    EmployeeBO employeeBO;
//    @RequestMapping("/project_detail")
//    public String project_details() {
//        return "project_detail";
//    }
    @RequestMapping("project_detail")
    public String project_details(@RequestParam String projectId, Model model, HttpServletRequest request){
        SuperController.projectId = projectId;

        model.addAttribute ( "projectData", projectBO.findProject ( projectId ) );
        model.addAttribute ( "loggerName", employeeBO.getEmployeeByIdNo(SuperController.idNo) );
        try {
            model.addAttribute ( "loadActivity", projectActivityBO.loadProjectActivity(SuperController.projectId) );
        }catch (NullPointerException e){
            System.out.println ("No Project activities Found" );
        }
        return "project_detail";
    }

    @RequestMapping("/project_detail_Edit")
    public ModelAndView index(Model model )  {
        ModelAndView mav = new ModelAndView ( "project_detail_Edit" );
        model.addAttribute ( "projectData", projectBO.findProject (  SuperController.projectId  ) );
        model.addAttribute ( "loggerName", employeeBO.getEmployeeByIdNo(SuperController.idNo) );
        try {
            model.addAttribute ( "loadActivity", projectActivityBO.loadProjectActivity(SuperController.projectId) );
        }catch (NullPointerException e){
            System.out.println ("No Project activities Found" );
        }
        return mav;
    }

    @PostMapping("saveActivities")
    public String registerUser(@ModelAttribute ProjectActivityDTO projectActivity) throws IOException {

        try {
            ProjectActivityDTO totalCount = projectActivityBO.getgenActivityIdCount ( );
            int q = Integer.parseInt ( totalCount.getActivityId () );
             int c= q+ 1 ;
            projectActivity.setActivityId ( String.valueOf ( c ) );
        } catch (NullPointerException e) {
            projectActivity.setActivityId ( "1"  );
        }
        projectActivity.setProjectsID ( SuperController.projectId );
        projectActivityBO.save ( projectActivity );
        return "redirect:/project_detail?projectId="+SuperController.projectId;
    }

}
