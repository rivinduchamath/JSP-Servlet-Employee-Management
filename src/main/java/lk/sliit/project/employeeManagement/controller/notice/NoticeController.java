package lk.sliit.project.employeeManagement.controller.notice;


import lk.sliit.project.employeeManagement.controller.SuperController;
import lk.sliit.project.employeeManagement.dto.NoticeDTO;
import lk.sliit.project.employeeManagement.dto.SalaryDTO;
import lk.sliit.project.employeeManagement.service.custom.EmployeeBO;
import lk.sliit.project.employeeManagement.service.custom.NoticeBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author: Rivindu-Wijayarathna
 * Date: 23-Apr-20
 */
@Controller
public class NoticeController { //notice.jsp For All Notice
    @Autowired
    EmployeeBO employeeBO;
    @Autowired
    NoticeBO noticeBO;
    @GetMapping("/notice")
    public ModelAndView loadNoticePage(Model model, @ModelAttribute SalaryDTO salaryDTO, HttpServletRequest request, HttpServletResponse response) throws ServletException,IllegalStateException, IOException {
        model.addAttribute ( "loggerName", employeeBO.getEmployeeByIdNo ( SuperController.idNo ) );
        ModelAndView mav = new ModelAndView ( "notice" );
        try {
            NoticeDTO totalCount = noticeBO.findTopByOrderByNoticeIdDesc ( );
            int x = Integer.parseInt ( totalCount.getNoticeId ( ) )+ 1;
            model.addAttribute ( "genNoticeId", x);
        } catch (NullPointerException e) {
            model.addAttribute ( "genNoticeId", 1 );
        }
        List<NoticeDTO> p =  noticeBO.findAllNotice();
        mav.addObject ( "findAllNotice", p );
        return mav;
    }

    @RequestMapping("noticeDelete")//deleteNotice
    public String deleteNotice(@RequestParam String noticeId) {
        //Calling delete Notice Method
        try {
            noticeBO.deleteNotice ( noticeId );
        }catch (Exception e){
            System.out.println ("Notice Id =" +noticeId+" Not Found" );
        }
        return "redirect:/notice";
    }

    @RequestMapping("noticeSave")//Save Or Update notice
    public String noticeSaveOrUpdate(@ModelAttribute NoticeDTO noticeDTO,Model model) {
        //Calling Update|Save Method
        noticeBO.addNotice ( noticeDTO );
        return "redirect:/notice";
    }

}//End Class
