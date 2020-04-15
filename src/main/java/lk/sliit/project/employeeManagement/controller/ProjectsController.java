package lk.sliit.project.employeeManagement.controller;

import lk.sliit.project.employeeManagement.business.custom.ProjectBO;
import lk.sliit.project.employeeManagement.business.custom.SalaryBO;
import lk.sliit.project.employeeManagement.dao.SalaryDAO;
import lk.sliit.project.employeeManagement.dto.ProjectDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author: Rivindu-Wijayarathna
 * Date: 23-Mar-20
 */
@Controller
public class ProjectsController {
    @Autowired
    ProjectBO projectBO;

    @RequestMapping("/projects")
    public ModelAndView projects(Model model, @ModelAttribute ProjectDTO projectDTO) {

        ModelAndView mav = new ModelAndView ( "projects" );
        List<ProjectDTO> p = projectBO.findAllProjects ( );
        for (ProjectDTO s: p) {
            System.out.println (s +"ssssssssssssssssss" );
        }
        mav.addObject ( "lias", p );
        return mav;
    }




}
