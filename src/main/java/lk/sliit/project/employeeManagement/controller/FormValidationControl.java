package lk.sliit.project.employeeManagement.controller;

import lk.sliit.project.employeeManagement.business.custom.DashboardBO;
import lk.sliit.project.employeeManagement.business.custom.EmployeeBO;
import lk.sliit.project.employeeManagement.dto.EmployeeDTO;
import org.hibernate.Session;

import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Blob;

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
    public String registerUser(@ModelAttribute EmployeeDTO employee,  Model model) throws IOException {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            EmployeeDTO author1 = new EmployeeDTO ();
            session.doWork(conn -> {
                author1.setPic ( BlobProxy.generateProxy(getImage()));
            });
            System.out.println (author1.getPic ()+"ssssssssssssssssssssssssssssss" );
            session.beginTransaction();
            session.save(employee);

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }

        model.addAttribute ( "employeeCountDashBoard", dashboardBO.getAllEmployeeCount ( ) );
        model.addAttribute ( "loggerName", employeeBO.getEmployeeByIdNo(SuperController.idNo) );
        model.addAttribute ( "empData", employeeBO.findAllEmployees ( ) );
        return "redirect:/Dashboard";
    }
    public static byte[] getImage() {
        Path path = Paths.get("D:\\\\JSP SERVlet\\\\artiyaCopy\\\\artiya\\\\src\\\\main\\\\webapp\\\\images\\\\icons\\\\s.jpg");
        byte[] data = null;
        try {
            data = Files.readAllBytes(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
    private BufferedImage deepCopy(BufferedImage bi, EmployeeDTO employee) throws IOException {
        Blob saveAs =employee.getPic () ;
        ColorModel cm = bi.getColorModel();
        boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
        WritableRaster raster = bi.copyData(null);
        BufferedImage cImg = new BufferedImage(cm, raster, isAlphaPremultiplied, null);
       // File saveImage = new File("D:\\JSP SERVlet\\artiyaCopy\\artiya\\src\\main\\webapp\\images\\icons", saveAs);
//        ImageIO.write(cImg, "jpg", saveImage);
//        ImageIO.write(cImg, "png", saveImage);
        return cImg;
    }


}
