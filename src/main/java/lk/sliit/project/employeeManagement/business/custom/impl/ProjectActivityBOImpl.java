package lk.sliit.project.employeeManagement.business.custom.impl;

import lk.sliit.project.employeeManagement.business.custom.ProjectActivityBO;
import lk.sliit.project.employeeManagement.dao.ProjectActivityDAO;
import lk.sliit.project.employeeManagement.dao.QueryDAO;
import lk.sliit.project.employeeManagement.dto.AttendanceDTO;
import lk.sliit.project.employeeManagement.dto.ProjectActivityDTO;
import lk.sliit.project.employeeManagement.entity.Attendance;
import lk.sliit.project.employeeManagement.entity.ProjectActivity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Rivindu-Wijayarathna
 * Date: 17-Apr-20
 */
@Service
@Transactional
public class ProjectActivityBOImpl implements ProjectActivityBO {
    @Autowired
    ProjectActivityDAO projectActivityDAO;
    @Override
    public List<ProjectActivityDTO> loadProjectActivity(String projectId) {
        System.out.println ("ssssssssssssssssssssssssssssssssssss"+projectId );
        Iterable <ProjectActivity> projectActivities = projectActivityDAO.findProjectActivitiesByProjectsIDEquals ( projectId );
        List <ProjectActivityDTO> dtos = new ArrayList<> ( );
        for (ProjectActivity projectActivity : projectActivities) {
            dtos.add ( new ProjectActivityDTO (
                    projectActivity.getActivityId ( ),
                    projectActivity.getActivity ( ),
                    projectActivity.getDescription (),
                    projectActivity.getDate ( ),
                    projectActivity.getProjectsID ().getProjectId ()
            ) );
        }
        System.out.println (dtos );
        return dtos;
    }

    @Override
    public ProjectActivityDTO getgenActivityIdCount() {
        ProjectActivity projectActivity = projectActivityDAO.findTopByOrderByActivityIdDesc ();
        return new ProjectActivityDTO (
                projectActivity.getActivityId ()
        );
    }

}
