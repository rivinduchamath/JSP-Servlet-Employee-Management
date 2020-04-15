package lk.sliit.project.employeeManagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: Rivindu-Wijayarathna
 * Date: 15-Apr-20
 */
@Controller
public class ProjectDetails {
    @RequestMapping("/project_detail")
    public String project_details() {
        return "project_detail";
    }
}
