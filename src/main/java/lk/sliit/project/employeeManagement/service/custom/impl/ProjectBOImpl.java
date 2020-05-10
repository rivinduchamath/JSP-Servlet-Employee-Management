package lk.sliit.project.employeeManagement.service.custom.impl;

import lk.sliit.project.employeeManagement.service.custom.ProjectBO;
import lk.sliit.project.employeeManagement.dao.ProjectActivityDAO;
import lk.sliit.project.employeeManagement.dao.ProjectDAO;
import lk.sliit.project.employeeManagement.dto.ProjectDTO;
import lk.sliit.project.employeeManagement.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: KV
 * Date: 15-Apr-20
 */
@Service
@Transactional//Project BusinessLogic / Service Implementation Class
public class ProjectBOImpl implements ProjectBO {
    //Automate Object Creation
    @Autowired
    ProjectDAO projectDAO;
    @Autowired
    ProjectActivityDAO projectActivityDAO;

    @Override// Find All
    @Transactional(readOnly = true)
    public List <ProjectDTO> findAllProjects() {
        Iterable <Project> allItems = projectDAO.findAll ( );
        List <ProjectDTO> dtos = new ArrayList <> ( );
        for (Project project : allItems) {
            dtos.add ( new ProjectDTO (
                    project.getProjectId ( ),
                    project.getProjectName ( ),
                    project.getTeamMembers ( ),
                    project.getProgress ( ),
                    project.getEstBudget ( ),
                    project.getSpentBudget ( ),
                    project.getDuration ( ),
                    project.getDate ( ),
                    project.getClient ( ),
                    project.getClientMobile ( )
            ) );
        }
        return dtos;//Return Find All
    } //End Find All

    @Override // Find Project By Id
    @Transactional(readOnly = true)
    public ProjectDTO findProject(String projectId) {
        Project project = projectDAO.findOne ( projectId );
        return new ProjectDTO (
                project.getProjectId ( ),
                project.getProjectName ( ),
                project.getTeamMembers ( ),
                project.getProgress ( ),
                project.getEstBudget ( ),
                project.getSpentBudget ( ),
                project.getDuration ( ),
                project.getDate ( ),
                project.getClient ( ),
                project.getClientMobile ( )
        );
    }//End Find Project By Id

    @Override //Get Top Project ID To Automatically Generate Project ID
    @Transactional(readOnly = true)
    public ProjectDTO getProjectAttCount() {
        Project project = projectDAO.findTopByOrderByProjectIdDesc ();
        return new ProjectDTO (
                project.getProjectId ()
        );
    }

    @Override//Save OR UPDATE Project
    public void saveProject(ProjectDTO project) {
        projectDAO.save(new Project (
                project.getProjectId ( ),
                project.getProjectName ( ),
                project.getTeamMembers ( ),
                project.getProgress ( ),
                project.getEstBudget ( ),
                project.getSpentBudget ( ),
                project.getDuration ( ),
                project.getDate ( ),
                project.getClient ( ),
                project.getClientMobile ( )));
    }//End Save OR Update

    @Override//Delete Project
    public void deleteProject(String pid) {
        projectDAO.delete ( pid );
    }

}//End Class
