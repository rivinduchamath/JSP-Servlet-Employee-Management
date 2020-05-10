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
public class E_CommerceController {//pricing_tables Page Controller
    @GetMapping("/e_commerce")//Load E Com JSP Page
    public ModelAndView load_eCommerce( ) throws ServletException,IllegalStateException, IOException {
        ModelAndView mav = new ModelAndView ( "e_commerce" );
        return mav;
    }
    @GetMapping("/pricing_tables")//Load E Com JSP Page
    public ModelAndView load_AllInventry( ) throws ServletException,IllegalStateException, IOException {
        ModelAndView mav = new ModelAndView ( "pricing_tables" );
        return mav;
    }
}//End Class

