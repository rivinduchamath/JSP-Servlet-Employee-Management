package lk.sliit.project.employeeManagement.dao;

import lk.sliit.project.employeeManagement.entity.Employee;
import lk.sliit.project.employeeManagement.entity.Project;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;

/**
 * @author: KV
 * Date: 15-Apr-20
 */
//Interface ProjectDAO Extend From CrudRepository InterFace
public interface ProjectDAO extends CrudRepository<Project, String> {
    //Get Highest Project from id
    Project findTopByOrderByProjectIdDesc();


    Iterable<Project> findProjectsByExpDateBetween(Date date, Date beforeOneMonth);
}
