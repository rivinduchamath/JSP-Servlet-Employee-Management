package lk.sliit.project.employeeManagement.business.custom;

import lk.sliit.project.employeeManagement.business.SuperBO;
import lk.sliit.project.employeeManagement.dto.ProjectDTO;

import java.util.List;

/**
 * @author: Rivindu-Wijayarathna
 * Date: 15-Apr-20
 */
public interface ProjectBO extends SuperBO {
    List<ProjectDTO> findAllProjects();
}
