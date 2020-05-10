package lk.sliit.project.employeeManagement.controller.gallery;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.ServletException;
import java.io.IOException;

/**
 * @author: Rivindu-Wijayarathna
 * Date: 23-Apr-20
 */
@Controller
public class GalleryController { //media_gallery.jsp Controller
    @GetMapping("/media_gallery")
    public ModelAndView loadMedia_galleryJSP( ) throws ServletException,IllegalStateException, IOException {
        ModelAndView mav = new ModelAndView ( "media_gallery" );
        return mav;
    }
}//End Class
