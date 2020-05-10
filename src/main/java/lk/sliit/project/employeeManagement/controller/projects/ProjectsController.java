package lk.sliit.project.employeeManagement.controller.projects;

import lk.sliit.project.employeeManagement.controller.SuperController;
import lk.sliit.project.employeeManagement.service.custom.EmployeeBO;
import lk.sliit.project.employeeManagement.service.custom.ProjectBO;
import lk.sliit.project.employeeManagement.dto.ProjectDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

/**
 * @author: KV
 * Date: 23-Mar-20
 */
@Controller
public class ProjectsController {//projects.jsp Controller
    @Autowired
    ProjectBO projectBO;
    @Autowired
    EmployeeBO employeeBO;

    @RequestMapping("/projects") // Load All Projects
    public ModelAndView loadProjects(Model model, @ModelAttribute ProjectDTO projectDTO) {
        model.addAttribute ( "loggerName", employeeBO.getEmployeeByIdNo( SuperController.idNo) );
        ModelAndView mav = new ModelAndView ( "projects" );
        List<ProjectDTO> p = projectBO.findAllProjects ( );
        for (ProjectDTO s: p) {
        }
        mav.addObject ( "lias", p );
        return mav;
    }
}//End Class
