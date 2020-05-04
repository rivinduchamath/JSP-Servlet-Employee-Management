package lk.sliit.project.employeeManagement.dao;

import lk.sliit.project.employeeManagement.entity.Notice;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;


/**
 * @author: Rivindu-Wijayarathna
 * Date: 03-May-20
 */
public interface NoticeDAO extends CrudRepository<Notice, String> {

    Notice findTopByOrderByNoticeIdDesc();

    Iterable<Notice> findAllByDateBetweenOrderByDateDesc(Date ds, Date d);
}
