package lk.sliit.project.employeeManagement.controller;

import lk.sliit.project.employeeManagement.business.custom.SalaryBO;
import lk.sliit.project.employeeManagement.dto.SalaryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Rivindu-Wijayarathna
 * Date: 26-Apr-20
 */
@Controller
public class invoiceController {
    @Autowired
    private SalaryBO salaryBO;
    @GetMapping("invoice")
    public String indexa2() {
        return "invoice";
    }

    @RequestMapping("deleteInvoiceSalary")
    public String deleteIN(@ModelAttribute SalaryDTO salaryDTO, Model model) {
        System.out.println ("sssssssssssssssssssssssssssssssssssssssssssssssssss"+ salaryDTO.getSalaryId ()+"a" );
        String[] sourceAry =  salaryDTO.getSalaryId ().split(" ");
        System.out.println (sourceAry+"ffffffffffffffffffffffffff" );
        for(String s : sourceAry) {
            System.out.println ("saaaaaaaaaaaaaaaaaaaaaaaaaaaaa"+s );
            salaryBO.deleteSalary (s);
        }

        return "redirect:/salary";
    }
}
