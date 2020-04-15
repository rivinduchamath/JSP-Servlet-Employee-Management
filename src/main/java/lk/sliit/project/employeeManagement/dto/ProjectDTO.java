package lk.sliit.project.employeeManagement.dto;

import java.sql.Date;

/**
 * @author: Rivindu-Wijayarathna
 * Date: 15-Apr-20
 */
public class ProjectDTO {
    private String projectId;
    private String projectName;
    private String teamMembers;
    private double progress;
    private double estBudget;
    private double spentBudget;
    private Date expDate;
    private Date date;
    private String client;
    private String clientMobile;

    public ProjectDTO(String projectId, String projectName, String teamMembers,
                      double progress, double estBudget, double spentBudget,
                      Date expDate, Date date, String client, String clientMobile) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.teamMembers = teamMembers;
        this.progress = progress;
        this.estBudget = estBudget;
        this.spentBudget = spentBudget;
        this.expDate = expDate;
        this.date = date;
        this.client = client;
        this.clientMobile = clientMobile;
    }

    public ProjectDTO() {
    }

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

    public void setDuration(Date expDate) {
        this.expDate = expDate;
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
        return "ProjectDTO{" +
                "projectId=" + projectId +
                ", projectName='" + projectName + '\'' +
                ", teamMembers='" + teamMembers + '\'' +
                ", progress=" + progress +
                ", estBudget=" + estBudget +
                ", spentBudget=" + spentBudget +
                ", expDate=" + expDate +
                ", date=" + date +
                ", client='" + client + '\'' +
                ", clientMobile='" + clientMobile + '\'' +
                '}';
    }
}
