package lk.sliit.project.employeeManagement.controller.projects;

import lk.sliit.project.employeeManagement.service.custom.EmployeeBO;
import lk.sliit.project.employeeManagement.service.custom.ProjectBO;
import lk.sliit.project.employeeManagement.controller.SuperController;
import lk.sliit.project.employeeManagement.dto.ProjectDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;

/**
 * @author: KV
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
    public String editProject(@RequestParam String projectId, Model model, HttpServletRequest request) {
       //Get add Clicked Project Data
        request.setAttribute ( "project", projectBO.findProject ( projectId ) );
        request.setAttribute ( "mode", "MODE_UP" );
        //Logger DAta
        model.addAttribute ( "loggerName", employeeBO.getEmployeeByIdNo( SuperController.idNo) );
        return "projectController";
    }

    @PostMapping("projectSave")//Save project
    public String saveProject(@ModelAttribute ProjectDTO projectDTO,Model model) {

        try {
            //Get Project Id
            ProjectDTO totalCount = projectBO.getProjectAttCount ( );
            int q = Integer.parseInt ( totalCount.getProjectId ( )  );
            int c= q+ 1 ;
            projectDTO.setProjectId ( String.valueOf ( c ) );
        } catch (NullPointerException e) {
            //Project Count = 0 then assign 1
            projectDTO.setProjectId ( "1"  );
        }
        //Calling Update Method
        projectBO.saveProject ( projectDTO );
        return "redirect:/projects";
    }
    @PostMapping("projectUpdate")//Update project
    public String updateProject(@ModelAttribute ProjectDTO projectDTO) {
        projectBO.saveProject ( projectDTO );
        return "redirect:/projects";
    }


    @RequestMapping("deleteProject")
    public String deleteProject(@RequestParam String pid, HttpServletRequest request) {
        projectBO.deleteProject ( pid );
        //Get All Employees After Delete
        request.setAttribute ( "listEmployeesTable", employeeBO.findAllEmployees ( ) );
        return "redirect:/projects";
    }

}//End Class
