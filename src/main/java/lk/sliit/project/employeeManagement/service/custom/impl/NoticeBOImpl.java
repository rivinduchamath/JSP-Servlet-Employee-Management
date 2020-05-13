package lk.sliit.project.employeeManagement.service.custom.impl;

import lk.sliit.project.employeeManagement.dao.NoticeDAO;
import lk.sliit.project.employeeManagement.dto.NoticeDTO;
import lk.sliit.project.employeeManagement.entity.Notice;
import lk.sliit.project.employeeManagement.service.custom.NoticeBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Rivindu-Wijayarathna
 * Date: 03-May-20
 */
@Service
@Transactional//Notice BusinessLogic / Service Implementation Class
public class NoticeBOImpl implements NoticeBO {
    //Automate Object Creation
    @Autowired
    NoticeDAO noticeDAO;

    @Override//Get Highest Notice Id
    @Transactional(readOnly = true)
    public NoticeDTO findTopByOrderByNoticeIdDesc() {
        Notice notice = noticeDAO.findTopByOrderByNoticeIdDesc ();
        return new NoticeDTO (
                notice.getNoticeId ()
        );
    }

    @Override//Save Or Update Notice
    public void addNotice(NoticeDTO noticeDTO) {
        noticeDAO.save(new Notice (
                noticeDTO.getNoticeId (),
                noticeDTO.getTitle (),
                noticeDTO.getDescription (),
                noticeDTO.getDate ()
               ));
    }

    @Override//Get All Notice
    @Transactional(readOnly = true)
    public List<NoticeDTO> findAllNotice() {
        Iterable <Notice> allItems = noticeDAO.findAll();
    List <NoticeDTO> dtos = new ArrayList<> ();
        for (Notice notice : allItems) {
        dtos.add(new NoticeDTO (
               notice.getNoticeId (),
                notice.getTitle (),
                notice.getDescription (),
                notice.getDate ()
        ));
    }
        return dtos;
}//End Find all

    @Override//Delete Notice
    public void deleteNotice(String noticeId) {
        noticeDAO.delete (noticeId); }

}//End Class