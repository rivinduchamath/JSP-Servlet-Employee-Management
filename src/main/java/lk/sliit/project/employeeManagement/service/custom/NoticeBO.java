package lk.sliit.project.employeeManagement.service.custom;

import lk.sliit.project.employeeManagement.dto.NoticeDTO;
import lk.sliit.project.employeeManagement.service.SuperBO;

import java.util.List;

/**
 * @author: Rivindu-Wijayarathna
 * Date: 03-May-20
 */
public interface NoticeBO extends SuperBO {
    NoticeDTO getNoticeId();

    void addNotice(NoticeDTO noticeDTO);

    List<NoticeDTO> findAllNotice();

    void deleteNotice(String noticeId);
}
