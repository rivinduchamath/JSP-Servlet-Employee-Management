package lk.sliit.project.employeeManagement.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * @author: KV
 * Date: 16-Apr-20
 */
@Entity//Employee Activity class
public class ProjectActivity implements SuperEntity {
    @Id
    private String activityId;
    private String activity;
    private String description;
    private Date date;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name = "projectsID", referencedColumnName = "projectId", nullable = true)
    private Project projectsID;


    //Add Full Arg Constructor
    public ProjectActivity(String activityId, String activity, String description, Date date, Project projectsID) {
        this.activityId = activityId;
        this.activity = activity;
        this.description = description;
        this.date = date;
        this.projectsID = projectsID;
    }
    //No arg constructor
    public ProjectActivity() {
    }
    //Getters And Setters
    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
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

    public Project getProjectsID() {
        return projectsID;
    }

    public void setProjectsID(Project projectsID) {
        this.projectsID = projectsID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override//Override toString
    public String toString() {
        return "ProjectActivity{" +
                "activityId='" + activityId + '\'' +
                ", activity='" + activity + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", projectsID=" + projectsID +
                '}';
    }//End toString Method
}//End Class
