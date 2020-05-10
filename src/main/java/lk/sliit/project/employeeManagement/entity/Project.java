package lk.sliit.project.employeeManagement.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


/**
 * @author: KV
 * Date: 23-Mar-20
 */
@Entity//Project Table
public class Project implements SuperEntity {
    @Id
    private String projectId;
    private String projectName;
    private String teamMembers;
    @Column(nullable = true)
    private double progress;
    @Column(nullable = true)
    private double estBudget;
    @Column(nullable = true)
    private double spentBudget;
    @Column(nullable = true)
    private Date expDate;
    @Column(nullable = true)
    private Date date;
    private String client;
    private String clientMobile;
    @OneToMany(mappedBy = "projectsID", cascade = {CascadeType.REMOVE,CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    private List<ProjectActivity> projects = new ArrayList<> ( );

    //No arg constructor
    public Project(){}

    //Add Full Arg Constructor
    public Project(String projectId, String projectName, String teamMembers, double progress, double estBudget, double spentBudget, Date duration, Date date, String client, String clientMobile) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.teamMembers = teamMembers;
        this.progress = progress;
        this.estBudget = estBudget;
        this.spentBudget = spentBudget;
        this.expDate = duration;
        this.date = date;
        this.client = client;
        this.clientMobile = clientMobile;
    }
    //Getters And Setters
    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(String teamMembers) {
        this.teamMembers = teamMembers;
    }

    public double getProgress() {
        return progress;
    }

    public void setProgress(double progress) {
        this.progress = progress;
    }

    public double getEstBudget() {
        return estBudget;
    }

    public void setEstBudget(double estBudget) {
        this.estBudget = estBudget;
    }

    public double getSpentBudget() {
        return spentBudget;
    }

    public void setSpentBudget(double spentBudget) {
        this.spentBudget = spentBudget;
    }

    public Date getDuration() {
        return expDate;
    }

    public void setDuration(Date duration) {
        this.expDate = duration;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getClientMobile() {
        return clientMobile;
    }

    public void setClientMobile(String clientMobile) {
        this.clientMobile = clientMobile;
    }

    public Date getExpDate() {
        return expDate;
    }

    public List <ProjectActivity> getProjects() {
        return projects;
    }

    @Override//Override toString
    public String toString() {
        return "Project{" +
                "projectId='" + projectId + '\'' +
                ", projectName='" + projectName + '\'' +
                ", teamMembers='" + teamMembers + '\'' +
                ", progress=" + progress +
                ", estBudget=" + estBudget +
                ", spentBudget=" + spentBudget +
                ", expDate=" + expDate +
                ", date=" + date +
                ", client='" + client + '\'' +
                ", clientMobile='" + clientMobile + '\'' +
                ", projects=" + projects +
                '}';
    }//End toString Method
}//End Class
