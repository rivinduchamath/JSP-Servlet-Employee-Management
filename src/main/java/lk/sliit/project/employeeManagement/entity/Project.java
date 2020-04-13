package lk.sliit.project.employeeManagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;


/**
 * @author: Rivindu-Wijayarathna
 * Date: 23-Mar-20
 */
@Entity
public class Project implements SuperEntity {
    @Id
    private int projectId;
    private String projectName;
    private String teamMembers;
    @Column(nullable = true)
    private double progress;
    @Column(nullable = true)
    private double estBudget;
    @Column(nullable = true)
    private double spentBudget;
    @Column(nullable = true)
    private double duration;
    private Date date;
    private String client;
    private String clientMobile;

    public Project(){}

    public Project(int projectId, String projectName, String teamMembers, double progress, double estBudget, double spentBudget, double duration, Date date, String client, String clientMobile) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.teamMembers = teamMembers;
        this.progress = progress;
        this.estBudget = estBudget;
        this.spentBudget = spentBudget;
        this.duration = duration;
        this.date = date;
        this.client = client;
        this.clientMobile = clientMobile;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
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

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
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

    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + projectId +
                ", projectName='" + projectName + '\'' +
                ", teamMembers='" + teamMembers + '\'' +
                ", progress=" + progress +
                ", estBudget=" + estBudget +
                ", spentBudget=" + spentBudget +
                ", duration=" + duration +
                ", date=" + date +
                ", client='" + client + '\'' +
                ", clientMobile='" + clientMobile + '\'' +
                '}';
    }
}
