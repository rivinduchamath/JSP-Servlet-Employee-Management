package lk.sliit.project.employeeManagement.controller;

import lk.sliit.project.employeeManagement.business.custom.DashboardBO;
import lk.sliit.project.employeeManagement.business.custom.EmployeeBO;
import lk.sliit.project.employeeManagement.business.custom.SalaryBO;
import lk.sliit.project.employeeManagement.dto.EmployeeDTO;
import lk.sliit.project.employeeManagement.dto.SalaryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author: Rivindu-Wijayarathna
 * Date: 08-Mar-20
 */
@Controller
public class FormValidationControl {

    //Automate Object Creation
    @Autowired
    private EmployeeBO employeeBO;
    @Autowired
    private SalaryBO salaryBO;
    @Autowired
    private DashboardBO dashboardBO;
    private  String path ="";
    private  File file ;


    //Load Employee add form from form_validation.jsp
    @RequestMapping("/form_validation")
    public String registration(HttpServletRequest request) {
        request.setAttribute ( "mode", "MODE_REGISTER" );
        return "form_validation";
    }
////////////////////////////////////////////////////
    //Save Employee from form_validation.jsp
    @PostMapping("Dashboards")
    public String registerUser(@ModelAttribute EmployeeDTO employee, HttpServletRequest request, Model model) throws IOException {

        if(employee.getPic ().equals ( "" ) & employee.getGender () == null ){
            employee.setPic ( "unknown.png" );
        }
        if(employee.getPic ().equals ( "" ) && employee.getGender ().equals ( "male" )){
            employee.setPic ( "user.png" );
        }
        if(employee.getPic ().equals ( "" ) && employee.getGender ().equals ( "female" )){
            employee.setPic ( "images.png" );
        }
        List<EmployeeDTO> employeeDTOS =employeeBO.findAllEmployees ( );
        int i =0;
        boolean check = false;
        for (EmployeeDTO e: employeeDTOS) {
            if (e.getIdNo ().equals ( employee.getIdNo () )){
                check =true;
                System.out.println ( e.getIdNo ());
                System.out.println ( employee.getIdNo ());
            }
            i++;
        }String a = String.valueOf ( i+1 );
        //Save Employee If Save Or Update Both
        employeeBO.save ( employee );
        //To Get All EmployeeCount Call Existing Method instead of Count Method

        //Create SalaryDTO Object
        SalaryDTO salaryDTO = new SalaryDTO (  );

            //Set Salary Id As TotalEmployee Count + 1

            salaryDTO.setSalaryId ( employee.getIdNo () );

            a = String.valueOf ( 0 );

            salaryDTO.setFullPayment ( a );


            salaryDTO.setEmployee ( employee.getIdNo ( ) );

            salaryBO.updateSalary ( salaryDTO );


        path = "C:/Users/User/Desktop/e/" + employee.getPic ();
        file = new File(path);
        BufferedImage cp, img;
        img = ImageIO.read(file);
        deepCopy(img,employee);
        model.addAttribute ( "employeeCountDashBoard", dashboardBO.getAllEmployeeCount ( ) );
        model.addAttribute ( "loggerName", employeeBO.getEmployeeByIdNo(SuperController.idNo) );
        model.addAttribute ( "empData", employeeBO.findAllEmployees ( ) );
        return "redirect:/Dashboard";
    }

    private BufferedImage deepCopy(BufferedImage bi, EmployeeDTO employee) throws IOException {
        String saveAs =employee.getPic () ;
        ColorModel cm = bi.getColorModel();
        boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
        WritableRaster raster = bi.copyData(null);
        BufferedImage cImg = new BufferedImage(cm, raster, isAlphaPremultiplied, null);
        File saveImage = new File("D:\\JSP SERVlet\\artiyaCopy\\artiya\\src\\main\\webapp\\images\\icons", saveAs);
        ImageIO.write(cImg, "jpg", saveImage);
        ImageIO.write(cImg, "png", saveImage);
        return cImg;
    }


}
