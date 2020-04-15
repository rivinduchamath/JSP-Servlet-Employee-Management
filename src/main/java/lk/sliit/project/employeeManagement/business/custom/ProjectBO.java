package lk.sliit.project.employeeManagement.business.custom;

import lk.sliit.project.employeeManagement.business.SuperBO;
import lk.sliit.project.employeeManagement.dto.EmployeeDTO;
import lk.sliit.project.employeeManagement.dto.ProjectDTO;
import lk.sliit.project.employeeManagement.entity.Project;

import java.util.List;

/**
 * @author: Rivindu-Wijayarathna
 * Date: 15-Apr-20
 */
public interface ProjectBO extends SuperBO {
    List<ProjectDTO> findAllProjects();

    ProjectDTO findProject(String projectId);


}
