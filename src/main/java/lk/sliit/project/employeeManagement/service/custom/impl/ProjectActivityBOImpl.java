package lk.sliit.project.employeeManagement.service.custom.impl;

import lk.sliit.project.employeeManagement.service.custom.ProjectActivityBO;
import lk.sliit.project.employeeManagement.dao.ProjectActivityDAO;
import lk.sliit.project.employeeManagement.dao.ProjectDAO;
import lk.sliit.project.employeeManagement.dto.ProjectActivityDTO;
import lk.sliit.project.employeeManagement.entity.ProjectActivity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: KV
 * Date: 17-Apr-20
 */
@Service
@Transactional//ProjectActivity BusinessLogic / Service Implementation Class
public class ProjectActivityBOImpl implements ProjectActivityBO {
    //Automate Object Creation
    @Autowired
    ProjectActivityDAO projectActivityDAO;
    @Autowired
    ProjectDAO projectDAO;

    //Get All Project Activities According To the Selected Project
    @Override
    @Transactional(readOnly = true)
    public List<ProjectActivityDTO> loadProjectActivity(String projectId) {
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
        return dtos;
    }//Get All Project Activities Method

    @Override//Get Top Project Activity ID to gen Activity Id
    @Transactional(readOnly = true)
    public ProjectActivityDTO getgenActivityIdCount() {
        ProjectActivity projectActivity = projectActivityDAO.findTopByOrderByActivityIdDesc ();
        return new ProjectActivityDTO (
                projectActivity.getActivityId ()
        );
    }

    @Override //Save OR Update Activity To Selected Project
    public void save(ProjectActivityDTO projectActivity) {
        projectActivityDAO.save(new ProjectActivity (
                projectActivity.getActivityId (),
                projectActivity.getActivity (),
                projectActivity.getDescription (),
                projectActivity.getDate (),
                projectDAO.findOne ( projectActivity.getProjectsID ())));
    }//End Activity Save | Update

}//End Class
