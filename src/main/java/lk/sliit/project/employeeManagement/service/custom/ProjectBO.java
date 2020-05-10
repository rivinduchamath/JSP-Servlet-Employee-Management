package lk.sliit.project.employeeManagement.service.custom;

import lk.sliit.project.employeeManagement.service.SuperBO;
import lk.sliit.project.employeeManagement.dto.ProjectDTO;
import java.util.List;

/**
 * @author: KV
 * Date: 15-Apr-20
 */
//Project Business Logic Interface
public interface ProjectBO extends SuperBO {
    //Find All Project
    List<ProjectDTO> findAllProjects();

    //Find Project By Id
    ProjectDTO findProject(String projectId);

    //Get Top Project To get Id
    ProjectDTO getProjectAttCount();
    //Save Or UPdate Project
    void saveProject(ProjectDTO projectDTO);
    //Delete Project
    void deleteProject(String pid);
}
