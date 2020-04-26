package lk.sliit.project.employeeManagement.controller.projects;

import lk.sliit.project.employeeManagement.business.custom.EmployeeBO;
import lk.sliit.project.employeeManagement.business.custom.ProjectBO;
import lk.sliit.project.employeeManagement.dto.ProjectDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author: Rivindu-Wijayarathna
 * Date: 23-Mar-20
 */
@Controller
public class ProjectsController {//projects.jsp Controller
    @Autowired
    ProjectBO projectBO;
    @Autowired
    EmployeeBO employeeBO;

    @RequestMapping("/projects") // Load All Projects
    public ModelAndView projects(Model model, @ModelAttribute ProjectDTO projectDTO) {

        ModelAndView mav = new ModelAndView ( "projects" );
        List<ProjectDTO> p = projectBO.findAllProjects ( );
        for (ProjectDTO s: p) {
        }
        mav.addObject ( "lias", p );
        return mav;
    }

}
