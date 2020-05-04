package lk.sliit.project.employeeManagement.dao;

import lk.sliit.project.employeeManagement.entity.Notice;
import org.springframework.data.repository.CrudRepository;

/**
 * @author: Rivindu-Wijayarathna
 * Date: 03-May-20
 */
public interface NoticeDAO extends CrudRepository<Notice, String> {

    Notice findTopByOrderByNoticeIdDesc();
}
