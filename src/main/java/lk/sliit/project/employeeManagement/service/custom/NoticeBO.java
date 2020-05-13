package lk.sliit.project.employeeManagement.service.custom;

import lk.sliit.project.employeeManagement.dto.NoticeDTO;
import lk.sliit.project.employeeManagement.service.SuperBO;
import java.util.List;

/**
 * @author: Rivindu-Wijayarathna
 * Date: 03-May-20
 */
//Notice Business Logic Interface
public interface NoticeBO extends SuperBO {

    //Generate top Notice Id
    NoticeDTO findTopByOrderByNoticeIdDesc();

    ////Save OR Update Notice
    void addNotice(NoticeDTO noticeDTO);

    //Get All Notice
    List<NoticeDTO> findAllNotice();

    //Delete
    void deleteNotice(String noticeId);

}
