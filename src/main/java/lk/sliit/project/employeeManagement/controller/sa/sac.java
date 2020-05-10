package lk.sliit.project.employeeManagement.controller.sa;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import java.io.IOException;
@Controller
public class sac {
    @GetMapping("/sa")
    public ModelAndView loadMedia_galleryJSP( ) throws ServletException,IllegalStateException, IOException {
        ModelAndView mav = new ModelAndView ( "sa" );
        return mav;
    }
}
