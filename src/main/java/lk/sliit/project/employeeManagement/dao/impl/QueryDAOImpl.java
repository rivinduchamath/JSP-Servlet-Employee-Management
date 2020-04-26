package lk.sliit.project.employeeManagement.dao.impl;

import lk.sliit.project.employeeManagement.dao.QueryDAO;
import lk.sliit.project.employeeManagement.entity.CustomEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author: Rivindu-Wijayarathna
 * Date: 08-Mar-20
 */

//Query DAO Repository To Join Query Implementations
@Repository
public class QueryDAOImpl implements QueryDAO {

    @PersistenceContext
    private EntityManager entityManager;
//
//    @Override
//    public Iterable <CustomEntity> findAll() {
//        List<Object[]> resultList = entityManager.createQuery("SELECT C.idNo,C.name, O.overtimeHours FROM employee C INNER JOIN Attendance O ON C.idNo=O.employeeID ")
//                .getResultList();
//        List<CustomEntity> al = new ArrayList<> ();
//        for (Object[] cols : resultList) {
//            al.add(new CustomEntity( (String) cols[1], (String) cols[2], (Double) cols[4]));
//        }
//        return al;
//    }
}
