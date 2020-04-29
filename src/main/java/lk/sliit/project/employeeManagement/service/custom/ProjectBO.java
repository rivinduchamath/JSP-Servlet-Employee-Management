package lk.sliit.project.employeeManagement.service.custom;

import lk.sliit.project.employeeManagement.service.SuperBO;
import lk.sliit.project.employeeManagement.dto.ProjectDTO;
import java.util.List;

/**
 * @author: Rivindu-Wijayarathna
 * Date: 15-Apr-20
 */
public interface ProjectBO extends SuperBO {
    List<ProjectDTO> findAllProjects();

    ProjectDTO findProject(String projectId);

}
