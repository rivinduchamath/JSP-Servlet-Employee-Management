package lk.sliit.project.employeeManagement.service.custom;

import lk.sliit.project.employeeManagement.dto.ProjectActivityDTO;
import java.util.List;

/**
 * @author: KV
 * Date: 17-Apr-20
 */
//ProjectActivity Business Logic Interface
public interface ProjectActivityBO {
    //Load All Project Activity According to Selected Project
    List<ProjectActivityDTO> loadProjectActivity(String projectId);

    //Get Top Project Id Count
    ProjectActivityDTO getgenActivityIdCount();

    //Save OR Update Activity
    void save(ProjectActivityDTO projectActivity);
}
