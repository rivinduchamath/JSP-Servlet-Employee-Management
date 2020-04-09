package lk.sliit.project.employeeManagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: Rivindu-Wijayarathna
 * Date: 23-Mar-20
 */
@Controller
public class ProjectsController {
    @PostMapping("/projects")
    public String index(HttpServletRequest request) {
        return "projects";
    }
}
