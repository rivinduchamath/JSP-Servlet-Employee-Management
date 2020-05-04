package lk.sliit.project.employeeManagement.service.custom.impl;

import lk.sliit.project.employeeManagement.dao.AttendanceDAO;
import lk.sliit.project.employeeManagement.dao.NoticeDAO;
import lk.sliit.project.employeeManagement.dto.AttendanceDTO;
import lk.sliit.project.employeeManagement.dto.NoticeDTO;
import lk.sliit.project.employeeManagement.entity.Attendance;
import lk.sliit.project.employeeManagement.entity.Notice;
import lk.sliit.project.employeeManagement.service.custom.NoticeBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author: Rivindu-Wijayarathna
 * Date: 03-May-20
 */
@Service
@Transactional
public class NoticeBOImpl implements NoticeBO {

    @Autowired
    NoticeDAO noticeDAO;
    @Override
    public NoticeDTO getNoticeId() {
        Notice notice = noticeDAO.findTopByOrderByNoticeIdDesc ();
        return new NoticeDTO (
                notice.getNoticeId ()
        );
    }

    @Override
    public void addNotice(NoticeDTO noticeDTO) {
        noticeDAO.save(new Notice (
                noticeDTO.getNoticeId (),
                noticeDTO.getTitle (),
                noticeDTO.getDescription (),
                noticeDTO.getDate ()
               ));

    }

    @Override
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
}

    @Override
    public void deleteNotice(String noticeId) {
        noticeDAO.delete (noticeId); }

    @Override
    public List <NoticeDTO> findAllNoticeDesc() {
        Date todaydate = new Date();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        java.util.Date dt = cal.getTime();
        Iterable <Notice> allItems = noticeDAO.findAllByDateBetweenOrderByDateDesc( dt, todaydate);
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
    }


}