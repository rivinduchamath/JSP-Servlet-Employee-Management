package lk.sliit.project.employeeManagement.business.custom;

import lk.sliit.project.employeeManagement.dto.ProjectActivityDTO;
import java.util.List;

/**
 * @author: Rivindu-Wijayarathna
 * Date: 17-Apr-20
 */
public interface ProjectActivityBO {
    List<ProjectActivityDTO> loadProjectActivity(String projectId);

    ProjectActivityDTO getgenActivityIdCount();

    void save(ProjectActivityDTO projectActivity);
}
