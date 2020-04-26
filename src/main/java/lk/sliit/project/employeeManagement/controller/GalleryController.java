package lk.sliit.project.employeeManagement.controller;

import lk.sliit.project.employeeManagement.dto.SalaryDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: Rivindu-Wijayarathna
 * Date: 23-Apr-20
 */
@Controller
public class GalleryController { //media_gallery.jsp Controller
    @GetMapping("/media_gallery")
    public ModelAndView index( ) throws ServletException,IllegalStateException, IOException {
        ModelAndView mav = new ModelAndView ( "media_gallery" );
        return mav;
    }
}
