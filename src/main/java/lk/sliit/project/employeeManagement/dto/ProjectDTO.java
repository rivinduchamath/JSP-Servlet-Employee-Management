package lk.sliit.project.employeeManagement.dto;

import java.sql.Date;

/**
 * @author: KV
 * Date: 15-Apr-20
 */

//Class ProjectDTO
public class ProjectDTO {
    private String projectId;
    private String projectName;
    private String projectDes;
    private double progress;
    private double estBudget;
    private double spentBudget;
    private Date expDate;
    private Date date;
    private String client;
    private String clientMobile;

    //ProjectDTO Full Arg Constructor
    public ProjectDTO(String projectId, String projectName, String projectDes,
                      double progress, double estBudget, double spentBudget,
                      Date expDate, Date date, String client, String clientMobile) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.projectDes = projectDes;
        this.progress = progress;
        this.estBudget = estBudget;
        this.spentBudget = spentBudget;
        this.expDate = expDate;
        this.date = date;
        this.client = client;
        this.clientMobile = clientMobile;
    }//End Full-arg

    //Project DTO Default Constructor
    public ProjectDTO() { }

    public ProjectDTO(String projectId) { //Constructor to find Top Project Id
        this.projectId = projectId;
    }

    public ProjectDTO(String projectId, String projectName, double progress, Date expDate, String client) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.progress = progress;
        this.expDate = expDate;
        this.client = client;
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
        return projectDes;
    }

    public void setTeamMembers(String projectDes) {
        this.projectDes = projectDes;
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

    // Override to-String Method
    @Override
    public String toString() {
        return "ProjectDTO{" +
                "projectId=" + projectId +
                ", projectName='" + projectName + '\'' +
                ", projectDes='" + projectDes + '\'' +
                ", progress=" + progress +
                ", estBudget=" + estBudget +
                ", spentBudget=" + spentBudget +
                ", expDate=" + expDate +
                ", date=" + date +
                ", client='" + client + '\'' +
                ", clientMobile='" + clientMobile + '\'' +
                '}';
    }//End to-String
}//End DTO
