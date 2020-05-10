package lk.sliit.project.employeeManagement.dao;

import lk.sliit.project.employeeManagement.entity.Notice;
import org.springframework.data.repository.CrudRepository;
import java.util.Date;


/**
 * @author: Rivindu-Wijayarathna
 * Date: 03-May-20
 */
//Interface NoticeDAO Extend From CrudRepository InterFace
public interface NoticeDAO extends CrudRepository<Notice, String> {

    //Get Highest Notice ID
    Notice findTopByOrderByNoticeIdDesc();

    //Get All Notice Between today and Before 1 month to show in DashBoard
    Iterable<Notice> findAllByDateBetweenOrderByDateDesc(Date ds, Date d);
}
