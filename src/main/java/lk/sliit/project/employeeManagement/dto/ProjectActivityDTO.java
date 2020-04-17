package lk.sliit.project.employeeManagement.dto;

import lk.sliit.project.employeeManagement.entity.Project;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Date;

/**
 * @author: Rivindu-Wijayarathna
 * Date: 17-Apr-20
 */
public class ProjectActivityDTO {
    private String activityId;
    private String activity;
    private String description;
    private Date date;
    private String projectsID;

    public ProjectActivityDTO(String activityId, String activity, String description, Date date, String projectsID) {
        this.activityId = activityId;
        this.activity = activity;
        this.description = description;
        this.date = date;
        this.projectsID = projectsID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProjectActivityDTO(String activityId) {        this.activityId = activityId;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getProjectsID() {
        return projectsID;
    }

    public void setProjectsID(String projectsID) {
        this.projectsID = projectsID;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    @Override
    public String toString() {
        return "ProjectActivityDTO{" +
                "activityId='" + activityId + '\'' +
                ", activity='" + activity + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", projectsID='" + projectsID + '\'' +
                '}';
    }
}

