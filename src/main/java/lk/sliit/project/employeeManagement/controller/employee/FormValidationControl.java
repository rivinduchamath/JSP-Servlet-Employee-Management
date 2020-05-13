package lk.sliit.project.employeeManagement.controller.employee;

import lk.sliit.project.employeeManagement.service.custom.DashboardBO;
import lk.sliit.project.employeeManagement.service.custom.EmployeeBO;
import lk.sliit.project.employeeManagement.controller.SuperController;
import lk.sliit.project.employeeManagement.dto.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

/**
 * @author: Minula
 * Date: 08-Mar-20
 */
@Controller
public class FormValidationControl {//form_validation.jsp Controller 2 Mods >> "MODE_UPDATE" and "MODE_Register"

    //Automate Object Creation
    @Autowired
    private EmployeeBO employeeBO;
    @Autowired
    private DashboardBO dashboardBO;
    private String path = "";
    private File file;

    //Update employee in the Table tables_dynamic.jsp + form_validation
    @RequestMapping("edit-employee")
    public String loadForm_validationUpdateMode(@RequestParam String idNo, Model model, HttpServletRequest request) {
        //Go To Mode Update In form_validation.jsp to Update Selected employee
        request.setAttribute ( "employee", employeeBO.getEmployeeByIdNo ( idNo ) );
        request.setAttribute ( "mode", "MODE_UPDATE" );
        //Get Logger User Data
        model.addAttribute ( "loggerName", employeeBO.getEmployeeByIdNo ( SuperController.idNo ) );
        return "form_validation";
    }

    //Load employee add form from form_validation.jsp Mode = "MODE_REGISTER"
    @RequestMapping("/form_validation")
    public String loadForm_validationSaveMode(HttpServletRequest request) {
        request.setAttribute ( "mode", "MODE_REGISTER" );
        return "form_validation";
    }

    //After Save Return to Dashboard
    @PostMapping("Dashboards")
    public String loadDashboard(@ModelAttribute EmployeeDTO employee, HttpServletRequest request, Model model) throws IOException {

        //If Some One Not Click In Gender Or Pic
        if (employee.getPic ( ).equals ( "" ) & employee.getGender ( ) == null) {
            employee.setPic ( "unknown.png" );
        }
        //If Some One Click In Gender as male and not choose Pic
        if (employee.getPic ( ).equals ( "" ) && employee.getGender ( ).equals ( "male" )) {
            employee.setPic ( "user.png" );
        }
        //If Some One Click In Gender as female and not choose Pic
        if (employee.getPic ( ).equals ( "" ) && employee.getGender ( ).equals ( "female" )) {
            employee.setPic ( "images.png" );
        }

        // employee Save Or Update Both
        employeeBO.save ( employee );
        //To Get All EmployeeCount Call Existing Method instead of Count Method

           //Get Img And Copy to Application
        path = "/home/rivindu/Desktop/e/" + employee.getPic ( );
        file = new File ( path );
        BufferedImage cp, img;
        img = ImageIO.read ( file );
        deepCopy ( img, employee );
        //In Dashboard employee Id No
        model.addAttribute ( "loggerName", employeeBO.getEmployeeByIdNo ( SuperController.idNo ) );
        //In Dashboard all employee
        model.addAttribute ( "empData", employeeBO.findAllEmployees ( ) );
        return "redirect:/Dashboard";
    }

    private BufferedImage deepCopy(BufferedImage bi, EmployeeDTO employee) throws IOException {
        String saveAs = employee.getPic ( );
        ColorModel cm = bi.getColorModel ( );
        boolean isAlphaPremultiplied = cm.isAlphaPremultiplied ( );
        WritableRaster raster = bi.copyData ( null );
        BufferedImage cImg = new BufferedImage ( cm, raster, isAlphaPremultiplied, null );
        File saveImage = new File ( "/media/rivindu/1.0 TB Hard Disk/IdeaProjects/ds/Hello-Servlet/src/main/webapp/images", saveAs );
        ImageIO.write ( cImg, "jpg", saveImage );
        ImageIO.write ( cImg, "png", saveImage );
        return cImg;
    }
}//End Class
