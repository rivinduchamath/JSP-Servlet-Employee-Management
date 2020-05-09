package lk.sliit.project.employeeManagement.dao;

import lk.sliit.project.employeeManagement.entity.ProjectActivity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * @author: Rivindu-Wijayarathna
 * Date: 17-Apr-20
 */
public interface ProjectActivityDAO extends CrudRepository<ProjectActivity, String> {

    @Query(value = "SELECT * FROM projectactivity WHERE projectsID=?1", nativeQuery = true)
    Iterable<ProjectActivity> findProjectActivitiesByProjectsIDEquals(String projectId);

    ProjectActivity findTopByOrderByActivityIdDesc();
}
