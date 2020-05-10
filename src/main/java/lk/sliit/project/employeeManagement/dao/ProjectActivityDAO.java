package lk.sliit.project.employeeManagement.dao;

import lk.sliit.project.employeeManagement.entity.ProjectActivity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * @author: KV
 * Date: 17-Apr-20
 */
//Interface ProjectActivityDAO Extend From CrudRepository InterFace
public interface ProjectActivityDAO extends CrudRepository<ProjectActivity, String> {

    //Get All Project Activities
    @Query(value = "SELECT * FROM ProjectActivity WHERE projectsID=?1", nativeQuery = true)
    Iterable<ProjectActivity> findProjectActivitiesByProjectsIDEquals(String projectId);

    //Get Highest Activity id
    ProjectActivity findTopByOrderByActivityIdDesc();
}
