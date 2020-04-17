package lk.sliit.project.employeeManagement.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * @author: Rivindu-Wijayarathna
 * Date: 16-Apr-20
 */
@Entity
public class ProjectActivity implements SuperEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private String activityId;
    private String activity;
    private String description;
    private Date date;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name = "projectsID", referencedColumnName = "projectId", nullable = true)
    private Project projectsID;

    public ProjectActivity(String activity, String description, Date date, Project projectsID) {
        this.activity = activity;
        this.description = description;
        this.date = date;
        this.projectsID = projectsID;
    }

    public ProjectActivity() {
    }

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

    @Override
    public String toString() {
        return "ProjectActivity{" +
                "activityId='" + activityId + '\'' +
                ", activity='" + activity + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", projectsID=" + projectsID +
                '}';
    }
}
