package lk.sliit.project.employeeManagement.dao;

import lk.sliit.project.employeeManagement.entity.Project;
import org.springframework.data.repository.CrudRepository;

/**
 * @author: Rivindu-Wijayarathna
 * Date: 15-Apr-20
 */
public interface ProjectDAO extends CrudRepository<Project, String> {
    Project getProjectByProjectId(String idNo);
}
