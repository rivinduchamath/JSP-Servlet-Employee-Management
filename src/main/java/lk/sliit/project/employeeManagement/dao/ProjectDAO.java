package lk.sliit.project.employeeManagement.dao;

import lk.sliit.project.employeeManagement.entity.Project;
import org.springframework.data.repository.CrudRepository;

/**
 * @author: Rivindu-Wijayarathna
 * Date: 15-Apr-20
 */
//Interface ProjectDAO Extend From CrudRepository InterFace
public interface ProjectDAO extends CrudRepository<Project, String> {
    //Get Project from id
    Project getProjectByProjectId(String idNo);
}
