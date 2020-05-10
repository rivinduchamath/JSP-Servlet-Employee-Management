package lk.sliit.project.employeeManagement.controller.eCommerce;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * @author: Rivindu-Wijayarathna
 * Date: 08-May-20
 */
@Controller
public class pricingTablesController {
    @GetMapping("/e_commerce")
    public ModelAndView index( ) throws ServletException,IllegalStateException, IOException {
        ModelAndView mav = new ModelAndView ( "e_commerce" );
        return mav;
    }
}

