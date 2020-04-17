package lk.sliit.project.employeeManagement.business.custom.impl;

import lk.sliit.project.employeeManagement.business.custom.ProjectBO;
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
 * @author: Rivindu-Wijayarathna
 * Date: 15-Apr-20
 */
@Service
@Transactional
public class ProjectBOImpl implements ProjectBO {
    @Autowired
    ProjectDAO projectDAO;
    @Autowired
    ProjectActivityDAO projectActivityDAO;

    @Override
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
        return dtos;
    }

    @Override
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

    }

}
